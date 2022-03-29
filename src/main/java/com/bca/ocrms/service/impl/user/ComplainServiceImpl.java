package com.bca.ocrms.service.impl.user;

import com.bca.ocrms.component.userAuthorize.Register;
import com.bca.ocrms.dto.user.ComplainDto;
import com.bca.ocrms.model.user.complain.Complain;
import com.bca.ocrms.repo.user.ComplainRepo;
import com.bca.ocrms.service.user.ComplainService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComplainServiceImpl implements ComplainService {
    private final ComplainRepo complainRepo;

    public ComplainServiceImpl(ComplainRepo complainRepo) {
        this.complainRepo = complainRepo;
    }

    @Override
    public ComplainDto save(ComplainDto complainDto) throws ParseException {
        Complain entity=new Complain();
        entity.setRegister(Register.getRegister());
        entity.setId(complainDto.getId());
        entity.setAddress(complainDto.getAddress());
        entity.setNationIdNumber(complainDto.getNationalIdNumber());
        entity.setCrimeType(complainDto.getCrimeType());
        entity.setCrimeDate(complainDto.getCrimeDate());
        entity.setDescription(complainDto.getDescription());

        return complainDto;
    }

    @Override
    public List<ComplainDto> findAll() {
        List<ComplainDto> complainDtoList=new ArrayList<>();
        List<Complain>complainList=complainRepo.getComplainList(Register.getRegister().getId());
        for (Complain complain:complainList)
        {
            complainDtoList.add(ComplainDto.builder()
                    .id(complain.getId())
                    .address(complain.getAddress())
                    .nationalIdNumber(complain.getNationIdNumber())
                    .crimeType(complain.getCrimeType())
                    .crimeDate(complain.getCrimeDate())
                    .description(complain.getDescription())
                    .build());
        }
        return complainDtoList;
    }

    @Override
    public ComplainDto findById(Integer integer) {
        Complain complain;
        Optional<Complain>optionalComplain=complainRepo.findById(Register.getRegister().getId());
        if (optionalComplain.isPresent())
        {
            complain=optionalComplain.get();
          return   ComplainDto.builder()
                    .id(complain.getId())
                    .address(complain.getAddress())
                    .nationalIdNumber(complain.getNationIdNumber())
                    .crimeType(complain.getCrimeType())
                    .crimeDate(complain.getCrimeDate())
                    .description(complain.getDescription())
                    .build();
        }
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
