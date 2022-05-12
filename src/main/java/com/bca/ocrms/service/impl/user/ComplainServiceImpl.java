package com.bca.ocrms.service.impl.user;

import com.bca.ocrms.components.AuthorizeUser;
import com.bca.ocrms.dto.user.ComplainDto;
import com.bca.ocrms.enums.ComplainStatus;
import com.bca.ocrms.model.user.complain.Complain;
import com.bca.ocrms.repo.user.ComplainRepo;
import com.bca.ocrms.repo.user.RegisterRepo;
import com.bca.ocrms.service.user.ComplainService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ComplainServiceImpl implements ComplainService {
    private final ComplainRepo complainRepo;
    private final RegisterRepo registerRepo;

    public ComplainServiceImpl(ComplainRepo complainRepo, RegisterRepo registerRepo)  {
        this.complainRepo = complainRepo;
        this.registerRepo = registerRepo;
    }

    @Override
    public ComplainDto save(ComplainDto complainDto) throws ParseException {
        Complain entity=new Complain();
        entity.setId(complainDto.getId());
        entity.setAddress(complainDto.getAddress());
        entity.setCrimeType(complainDto.getCrimeType());
        entity.setCrimeDate(new SimpleDateFormat("yyyy-MM-dd").parse(complainDto.getCrimeDate()));
        entity.setComplainDate(new Date());
        entity.setRegister(AuthorizeUser.getRegister());
        if(entity.getId() == null){
            entity.setComplainStatus(ComplainStatus.PENDING);
        }else {
            entity.setComplainStatus(complainDto.getComplainStatus());
        }
        entity.setDescription(complainDto.getDescription());
        entity=complainRepo.save(entity);

        return complainDto;
    }

    @Override
    public List<ComplainDto> findAll() {
        //return entity convert the dto
        List<ComplainDto> complainList = new ArrayList<>();
        List<Complain> complainList1 = complainRepo.getComplainList(AuthorizeUser.getRegister().getId());
        for (Complain complain : complainList1){
            complainList.add(ComplainDto.builder()
                    .id(complain.getId())
                    .address(complain.getAddress())
                    .crimeType(complain.getCrimeType())
                    .crimeDate(new SimpleDateFormat("yyyy-MM-dd").format(complain.getCrimeDate()))
                    .complainStatus(complain.getComplainStatus())
                    .complainDate(complain.getComplainDate())
                    .description(complain.getDescription())
                    .build());
        }
        return complainList;
    }

    @Override
    public ComplainDto findById(Integer integer) {
        Complain complain;
        Optional<Complain> optionalComplain=complainRepo.findById(integer);
        if (optionalComplain.isPresent())
        {
            complain=optionalComplain.get();
          return   ComplainDto.builder()
                    .id(complain.getId())
                    .address(complain.getAddress())
                    .crimeType(complain.getCrimeType())
                    .complainDate(complain.getComplainDate())
                    .crimeDate(new SimpleDateFormat("yyyy-MM-dd").format(complain.getCrimeDate()))
                    .complainStatus(complain.getComplainStatus())
                    .description(complain.getDescription())
                    .build();
        }
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
        complainRepo.deleteById(integer);

    }

    public List<ComplainDto> findAllComplain(){
        //return entity convert the dto
        List<ComplainDto> complainList = new ArrayList<>();
        List<Complain> complainList1 = complainRepo.findAll();
        for (Complain complain : complainList1){
            complainList.add(ComplainDto.builder()
                    .id(complain.getId())
                    .address(complain.getAddress())
                    .crimeType(complain.getCrimeType())
                    .crimeDate(new SimpleDateFormat("yyyy-MM-dd").format(complain.getCrimeDate()))
                    .complainStatus(complain.getComplainStatus())
                    .complainDate(complain.getComplainDate())
                    .description(complain.getDescription())
                    .register(complain.getRegister())
                    .build());
        }
        return complainList;
    }
    public boolean getVerifiedStatus()
    {
        return getVerifiedStatus();
    }
}
