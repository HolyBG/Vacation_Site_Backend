package com.elixirr.labRedo2;

import com.elixirr.labRedo2.DAO.CustomerRepository;
import com.elixirr.labRedo2.DAO.DivisionRepository;
import com.elixirr.labRedo2.Entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() == 1) {
            Customer coco = new Customer();
            coco.setFirstName("Coco");
            coco.setLastName("Jones");
            coco.setAddress("545 Ham Street");
            coco.setPhone("7897899988");
            coco.setPostal_code("85856");
            coco.setDivision(divisionRepository.getReferenceById(5L));

            customerRepository.save(coco);

            Customer alex = new Customer();
            alex.setFirstName("Alex");
            alex.setLastName("Mace");
            alex.setAddress("123 Easy Street");
            alex.setPhone("3698885254");
            alex.setPostal_code("56985");
            alex.setDivision(divisionRepository.getReferenceById(35L));

            customerRepository.save(alex);

            Customer mia = new Customer();
            mia.setFirstName("Mia");
            mia.setLastName("Huff");
            mia.setAddress("898 Spring Drive");
            mia.setPhone("7412365544");
            mia.setPostal_code("45456");
            mia.setDivision(divisionRepository.getReferenceById(15L));

            customerRepository.save(mia);

            Customer john = new Customer();
            john.setFirstName("John");
            john.setLastName("Chief");
            john.setAddress("117 Ring Road");
            john.setPhone("111775555");
            john.setPostal_code("87898");
            john.setDivision(divisionRepository.getReferenceById(8L));

            customerRepository.save(john);

            Customer shep = new Customer();
            shep.setFirstName("Commander");
            shep.setLastName("Shepard");
            shep.setAddress("7 Normandy Ave");
            shep.setPhone("8529634474");
            shep.setPostal_code("78945");
            shep.setDivision(divisionRepository.getReferenceById(7L));

            customerRepository.save(shep);

        }

    }
}
