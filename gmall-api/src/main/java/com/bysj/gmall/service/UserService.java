package com.bysj.gmall.service;
import com.bysj.gmall.bean.UmsMember;
import com.bysj.gmall.bean.UmsMemberReceiveAddress;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
