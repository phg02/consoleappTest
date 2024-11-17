package util;

import controller.impl.*;
import model.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class FileHandler {
    private StringToDate stringToDate;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public FileHandler() {
        stringToDate = new StringToDate();
    }

    public HashSet<Tenant> getTenantData() {
        // File path
        final String filePathToTenant = "src/resource/tenant.txt";

        // List to store Tenant objects
        HashSet<Tenant> tenants = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePathToTenant))) {
            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Split the line by the "|" delimiter
                String[] parts = line.split("\\|");

                // Ensure correct number of fields
                if (parts.length == 4) {
                    String id = parts[0];
                    String fullName = parts[1];
                    Date dateOfBirth = stringToDate.convertStringToDate(parts[2]);
                    String contactInformation = parts[3];

                    // Create a Tenant object and add it to the list
                    Tenant tenant = new Tenant(id, fullName, dateOfBirth, contactInformation);
                    tenants.add(tenant);
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
            // Print the tenants to verify
//            System.out.println("Tenants loaded from file:");
//            for (Tenant tenant : tenants) {
//                LocalDateTime localDateTime = tenant.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                System.out.println(tenant.getId() + " " + tenant.getFullName() + " " + dtf.format(localDateTime) + " " + tenant.getContactInformation());
//            }
            return tenants;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return tenants;
    }

    public HashSet<Owner> getOwnerData() {
        // File path
        final String filePathToOwner = "src/resource/owner.txt";

        // List to store Tenant objects
        HashSet<Owner> owners = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePathToOwner))) {
            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Split the line by the "|" delimiter
                String[] parts = line.split("\\|");

                // Ensure correct number of fields
                if (parts.length == 4) {
                    String id = parts[0];
                    String fullName = parts[1];
                    Date dateOfBirth = stringToDate.convertStringToDate(parts[2]);
                    String contactInformation = parts[3];

                    // Create a Tenant object and add it to the list
                    Owner owner = new Owner(id, fullName, dateOfBirth, contactInformation);
                    owners.add(owner);
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
            // Print the tenants to verify
//            System.out.println("Tenants loaded from file:");
//            for (Owner owner : owners) {
//                LocalDateTime localDateTime = owner.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                System.out.println(owner.getId() + " " + owner.getFullName() + " " + dtf.format(localDateTime) + " " + owner.getContactInformation());
//            }
            return owners;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return owners;
    }


    public HashSet<Host> getHostData() {
        // File path
        final String filePathToHost = "src/resource/host.txt";

        // List to store Tenant objects
        HashSet<Host> hosts = new HashSet<>();


        try (BufferedReader br = new BufferedReader(new FileReader(filePathToHost))) {
            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Split the line by the "|" delimiter
                String[] parts = line.split("\\|");

                // Ensure correct number of fields
                if (parts.length == 4) {
                    String id = parts[0];
                    String fullName = parts[1];
                    Date dateOfBirth = stringToDate.convertStringToDate(parts[2]);
                    String contactInformation = parts[3];

                    // Create a Tenant object and add it to the list
                    Host host = new Host(id, fullName, dateOfBirth, contactInformation);
                    hosts.add(host);
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
//            // Print the tenants to verify
//            System.out.println("Tenants loaded from file:");
//            for (Host host : hosts) {
//                LocalDateTime localDateTime = host.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                System.out.println(host.getId() + " " + host.getFullName() + " " + dtf.format(localDateTime) + " " + host.getContactInformation());
//            }
            return hosts;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return hosts;
    }

    public HashSet<ResidentialProperty> getResidentialProperty(){
        String fileName = "src/resource/residentialProperty.txt";
        HashSet<ResidentialProperty> properties = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Parsing fields from the text file
                String id = parts[0];
                String address = parts[1];
                double pricing = Double.parseDouble(parts[2]);
                Property.Status status = Property.Status.valueOf(parts[3]); // Convert string to enum
                OwnerManagerImpl ownerManager = new OwnerManagerImpl();
                Owner owner = ownerManager.getOwnerByID(parts[4]);
                int numberOfBedrooms = Integer.parseInt(parts[5]);
                boolean hasGarden = Boolean.parseBoolean(parts[6]);
                boolean petFriendly = Boolean.parseBoolean(parts[7]);

                // Create a ResidentialProperty object
                ResidentialProperty property = new ResidentialProperty(
                        id, address, pricing, status, owner, numberOfBedrooms, hasGarden, petFriendly);
                properties.add(property);
                return properties;

            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return properties;
    }


    public HashSet<CommercialProperty> getCommercialProperty(){
        String fileName = "src/resource/commercialProperty.txt";
        HashSet<CommercialProperty> commercialProperties = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Parsing fields from the text file
                String id = parts[0];
                String address = parts[1];
                double pricing = Double.parseDouble(parts[2]);
                Property.Status status = Property.Status.valueOf(parts[3]); // Convert string to enum
                OwnerManagerImpl ownerManager = new OwnerManagerImpl();
                Owner owner = ownerManager.getOwnerByID(parts[4]);
                String businessType = parts[5];
                int parkingSlots = Integer.parseInt(parts[6]);
                double squareFootage = Double.parseDouble(parts[7]);

                // Create a CommercialProperty object
                CommercialProperty property = new CommercialProperty(
                        id, address, pricing, status, owner, businessType, parkingSlots, squareFootage);
                commercialProperties.add(property);



            }
//            for(CommercialProperty com : commercialProperties){
//                System.out.println(com.getId() + " " + com.getAddress() + " " + com.getPricing() + " " + com.getStatus() + " " + com.getOwner().getFullName() + " " + com.getBusinessType() + " " + com.getParkingSlots() + " " + com.getSquareFootage());
//            }
            return commercialProperties;

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return commercialProperties;
    }

    public HashSet<RentalAgreement> getRentalAgreement(){
        String fileName = "src/resource/rentalAgreement.txt";
        HashSet<RentalAgreement> rentalAgreements = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Parsing fields from the text file
                String id = parts[0];
                Owner owner = new OwnerManagerImpl().getOwnerByID(parts[1]);
                Host host = new HostManagerImpl().getHostByID(parts[2]);
                Tenant mainTenant = new TenantManagerImpl().getTenantByID(parts[3]);
                String[] subTenantIds = parts[4].split(",");
                Property property;
                System.out.println(parts[5]);
                if(parts[5].startsWith("RP")){
                    property = new ResidentialPropertyManagerImpl().getResidentialPropertyByID(parts[5]);
                    System.out.println(property);
                }
                else{
                    CommercialPropertyManagerImpl commercialPropertyManager = new CommercialPropertyManagerImpl();
                    property = commercialPropertyManager.getCommercialPropertyByID(parts[5]);
                    System.out.println(property);

                }
                RentalAgreement.Period period = RentalAgreement.Period.valueOf(parts[6]);
                Date contract = stringToDate.convertStringToDate(parts[7]);
                double rentingFee = Double.parseDouble(parts[8]);
                RentalAgreement.Status status = RentalAgreement.Status.valueOf(parts[9]);

                // Create a RentalAgreement object
                RentalAgreement rentalAgreement = new RentalAgreement(
                        id, owner, host, mainTenant, property, period, contract, rentingFee, status);
                rentalAgreements.add(rentalAgreement);
                for (String subIs : subTenantIds) {
                    rentalAgreement.addSubTenant(new TenantManagerImpl().getTenantByID(subIs));
                }
            }
//            rentalAgreements.forEach(a -> System.out.println(a.getProperty().getAddress()));
            return rentalAgreements;

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return rentalAgreements;
    }
}