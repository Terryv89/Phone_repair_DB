package org.example.mobiles;

import static org.example.Main.scanner;

public class MobilesManager {

    public static String welcomeMenuMobile() {
        System.out.println("welcome to the mobile menu");
        System.out.println("1. to look at our mobile");
        System.out.println("2. to add a mobile");
        System.out.println("3. to update a mobile");
        System.out.println("4. to delete a mobile");
        System.out.println("or 5 to exit");
        String mobileMenu = String.valueOf(scanner.nextInt());
        return mobileMenu;
    }
    public static void addNewMobile() {
        System.out.println("Enter new mobile details: ");
        System.out.println("Enter the brand name: ");
        String brandName = scanner.next();
        System.out.println("Enter the model name: ");
        String modelName = scanner.next();

        Mobiles mobiles = new Mobiles(brandName,modelName);
        boolean isCustomerAdded = MobilesDB.addMobile(mobiles);

        if (isCustomerAdded){
            System.out.println("Mobile Added successfully");
        }else {
            System.out.println("Failed to add The new mobile");
        }
    }

    public static void updateMobileInfo() {
        System.out.println("Update mobile info.");
        System.out.println("Enter the id of the mobile you wanna update: ");
        int mobileId = scanner.nextInt();
        System.out.println("Enter your new brand name: ");
        String brandName = scanner.next();
        System.out.println("Enter your new model name: ");
        String modelName = scanner.next();

        Mobiles mobiles = new Mobiles(mobileId,brandName,modelName);
        boolean isMobileUpdated = MobilesDB.updateMobile(mobiles);

        if (isMobileUpdated){
            System.out.println("Mobile info updated successfully");
        }else {
            System.out.println("Failed to update Mobile info");
        }
    }
    public static void deleteMobileMenu() {
        System.out.println("Delete a mobile");
        System.out.println("Enter the mobile id you wanna delete: ");
        int mobileId = scanner.nextInt();

        boolean isMobileDeleted = MobilesDB.deleteMobile(mobileId);

        if (isMobileDeleted){
            System.out.println("You successfully deleted the mobile");
        }else {
            System.out.println("Failed to delete the mobile");
        }
    }


}
