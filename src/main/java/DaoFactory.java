public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        System.out.println("[DaoFactory.getAdsDao] getAdsDao called!");
        if (adsDao == null) {
            System.out.println("[DaoFactory.getAdsDao] Creating a new ads dao");
            adsDao = new ListAdsDao();
        } else {
            System.out.println("[DaoFactory.getAdsDao] Using our existing object");
        }
        return adsDao;
    }
}
