package com.sumutella.petclinic.map;

import com.sumutella.petclinic.models.Owner;
import com.sumutella.petclinic.models.Pet;
import com.sumutella.petclinic.services.OwnerService;
import com.sumutella.petclinic.services.PetService;
import com.sumutella.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author sumutella
 * @time 2:35 PM
 * @since 11/27/2019, Wed
 */

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Integer> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null){
            if (owner.getPets()!= null){
                owner.getPets().forEach( pet -> {if(pet.getPetType() != null){
                    if (pet.getPetType().getId() == null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else {
                    throw new RuntimeException("Pet type is required");
                }

                if (pet.getId()==null){
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }

                });
            }
        }
        return super.save(owner);
    }

    @Override
    public Owner findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLname(String lname) {
        return null;
    }
}
