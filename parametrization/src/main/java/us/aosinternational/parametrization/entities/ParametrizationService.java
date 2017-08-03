package us.aosinternational.parametrization.entities;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StringValue;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import us.aosinternational.parametrization.connectDS.GoogleDataStoreComponent;

/**
 *
 * @author Cristian David Franco Garcia
 */
@Service
public class ParametrizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParametrizationService.class);

    private final Datastore datastore;

    public ParametrizationService() {
        GoogleDataStoreComponent googleDataStoreComponent = new GoogleDataStoreComponent();
        this.datastore = googleDataStoreComponent.getDatastore();
    }

    public Parametrization getParametrization() throws IOException {
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("parametrization").build();
        QueryResults<Entity> results = datastore.run(query);
        Entity entity = results.next();
        return new Parametrization(entity.getLong("initialDelay"), entity.getLong("period"), entity.getString("customerEmailSubject"), entity.getString("customerEmailContentText"));
    }

    public void saveParametrization(Parametrization parametrizationData) throws IOException {
        // Selección del "Kind" donde se van a almacenar los datos y creación de  un ID automaticamente para cada registro
        //KeyFactory keyFactory = datastore.newKeyFactory().setKind("parametrization");
        //Key parametrizationKey = datastore.allocateId(keyFactory.newKey());
        // The Cloud Datastore key for the new entity
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("parametrization").build();
        QueryResults<Entity> parametrizations = datastore.run(query);
        Key parametrizationKey = datastore.newKeyFactory().setKind("parametrization").newKey("parametrization");
        if (!parametrizations.hasNext()) {
            Entity parametrization = Entity.newBuilder(parametrizationKey)
                    .set("initialDelay", parametrizationData.getInitialDelay())
                    .set("period", parametrizationData.getPeriod())
                    .set("customerEmailSubject", parametrizationData.getCustomerEmailSubject())
                    .set("customerEmailContentText", StringValue.newBuilder(parametrizationData.getCustomerEmailContentText()).setExcludeFromIndexes(true).build())
                    .build();
            // Saves the entity
            datastore.put(parametrization);
        } else {
            Entity employee = datastore.get(parametrizationKey);
            Entity parametrization = Entity.newBuilder(employee)
                    .set("initialDelay", parametrizationData.getInitialDelay())
                    .set("period", parametrizationData.getPeriod())
                    .set("customerEmailSubject", parametrizationData.getCustomerEmailSubject())
                    .set("customerEmailContentText", StringValue.newBuilder(parametrizationData.getCustomerEmailContentText()).setExcludeFromIndexes(true).build())
                    .build();
            datastore.put(parametrization);
            LOGGER.info("Parametrización almacenada correctamente");
        }
    }
}
