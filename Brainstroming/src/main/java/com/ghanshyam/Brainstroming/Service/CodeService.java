//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Service;

import com.ghanshyam.Brainstroming.Collection.OfficialCode;
import com.ghanshyam.Brainstroming.Collection.UnofficialCode;
import com.ghanshyam.Brainstroming.Repository.OfficialCodeRepository;
import com.ghanshyam.Brainstroming.Repository.UnofficialCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
    @Autowired
    OfficialCodeRepository officialCodeRepository;
    @Autowired
    UnofficialCodeRepository unofficialCodeRepository;

    public CodeService() {
    }

    public boolean saveOfficial(OfficialCode officialCode) {
        this.officialCodeRepository.save(officialCode);
        return true;
    }

    public boolean saveUnofficial(UnofficialCode unofficialCode) {
        this.unofficialCodeRepository.save(unofficialCode);
        return true;
    }

    public String getofficialcode(Long submissionId) {
        return ((OfficialCode)this.officialCodeRepository.findById(submissionId).get()).getCode();
    }

    public String getunofficialcode(Long submissionId) {
        return ((UnofficialCode)this.unofficialCodeRepository.findById(submissionId).get()).getCode();
    }
}
