import controller.impl.*;
import model.Host;
import model.Owner;
import util.FileHandler;

import java.util.Date;
import controller.impl.TenantManagerImpl;

public class src {
    public static void main(String[] args) {
//        Owner person1 = new Owner("1", "John Doe", new Date(), "1234567890");
//        Owner person2 = new Owner("1", "John Doe", new Date(), "1234567890");
//
//        System.out.println(person1.getId());

        FileHandler fileHandler = new FileHandler();
        fileHandler.getRentalAgreement();

//        TenantManagerImpl tenantManager = new TenantManagerImpl();
//        System.out.print(tenantManager.getTenantByID("T013").getFullName());

//        OwnerManagerImpl ownerManager = new OwnerManagerImpl();
//        System.out.print(ownerManager.getOwnerByID("O007").getFullName());

//        HostManagerImpl hostManager = new HostManagerImpl();
//        System.out.print(hostManager.getHostByID("H001").getFullName());

//        CommercialPropertyManagerImpl commercialPropertyManager = new CommercialPropertyManagerImpl();
//        commercialPropertyManager.getAllCommercialProperties().forEach(commercialProperty -> System.out.println(commercialProperty.getOwner().getFullName()));


//        ResidentialPropertyManagerImpl residentialPropertyManager = new ResidentialPropertyManagerImpl();
//        System.out.println(residentialPropertyManager.getResidentialPropertyByID("RP003").getAddress());
    }
}
