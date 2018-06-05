import java.util.List;

public class FactoryTest {
    public static void main(String[] args) {
        // The first time a request is made
        System.out.println("----- START -----");
        Ads dao = DaoFactory.getAdsDao();
        List<Ad> ads = dao.all();

        for (Ad ad : ads) {
            System.out.printf(
                "<Ad id=%d title='%s', description='%s' />\n",
                ad.getId(),
                ad.getTitle(),
                ad.getDescription()
            );
        }

        // subsequent requests
        System.out.println("--------------------");
        System.out.println("Getting a new dao...");
        System.out.println("--------------------");

        Ads dao2 = DaoFactory.getAdsDao();
        List<Ad> ads2 = dao2.all();

        System.out.println("----- END -----");
    }
}
