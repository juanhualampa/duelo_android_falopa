package grupo6uis.dueloentreleyendasfinal.duelo.service;
import retrofit.RestAdapter;

/**
 * Created by luciano on 27/11/15.
 */


public class DueloServiceInstance {

    public static DueloService createDueloService() {
        String SERVER_IP = "10.0.2.2"; //esta ip se usa para comunicarse con mi localhost en el emulador de Android Studio
        String SERVER_IP_GENY = "192.168.1.68";//esta ip se usa para comunicarse con mi localhost en el emulador de Genymotion
        String API_URL = "http://"+ SERVER_IP_GENY +":9000";
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        DueloService dueloService = restAdapter.create(DueloService.class);
        return dueloService;
    }

}
