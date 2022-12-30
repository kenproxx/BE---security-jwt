package com.example.airbnb.service.impl;

import com.example.airbnb.dto.SearchUserDetail;
import com.example.airbnb.dto.TongSoNganh;
import com.example.airbnb.model.ThongSo;
import com.example.airbnb.model.UserDetail;
import com.example.airbnb.repository.LopHocRepository;
import com.example.airbnb.repository.UserDetailRepository;
import com.example.airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LopHocRepository lopHocRepository;

    @Autowired
    private ThongSoService thongSoService;

    public void save(UserDetail userDetail) {
        userDetailRepository.save(userDetail);
    }

    public Iterable<UserDetail> findAll() {
        return userDetailRepository.findAll();
    }

    public UserDetail findByUsername(String username) {
        return userDetailRepository.findByUsername(username);
    }

    public ResponseEntity<UserDetail> updateDetail(UserDetail userDetail) {
        String userName = userDetail.getUsername();
        if (userRepository.existsByUsername(userName)) {
            if (userDetailRepository.existsByUsername(userName)) {
                UserDetail currentUser = userDetailRepository.findByUsername(userName);
                userDetail.setUdid(currentUser.getUdid());
            }
            String fullname = userDetail.getTenThanh() + userDetail.getTenGoi();
            userDetail.setTenDayDu(fullname);
            save(userDetail);
            return ResponseEntity.ok(userDetail);
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<UserDetail> addToClass(String username, Long classId) {
        if (lopHocRepository.existsById( classId)) {
            if (userRepository.existsByUsername(username)) {
                UserDetail userDetail = findByUsername(username);
                userDetail.setLopId(classId);
                save(userDetail);
                return ResponseEntity.ok(userDetail);
            }
        }
        return ResponseEntity.badRequest().build();
    }

//    thêm list học sinh vào lớp
    public ResponseEntity<UserDetail> addToClass(List<UserDetail> userDetails, Long classId) {
        for ( UserDetail userDetail : userDetails) {
            String username = userDetail.getUsername();
            if (lopHocRepository.existsById(classId)) {
                if (userRepository.existsByUsername(username)) {
                    userDetail.setLopId(classId);
                    save(userDetail);
                    return ResponseEntity.ok(userDetail);
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }

    public List<UserDetail> findAllByLopId(Long lopId) {
        return userDetailRepository.findAllByLopId(lopId);
    }

    public List<UserDetail> searchUserDetail(SearchUserDetail searchUserDetail) {
        return userDetailRepository.
                findUserDetailByUsernameContainingAndTenGoiContainingAndLopIdAndNganh(
                        searchUserDetail.getUsername(), searchUserDetail.getTenGoi(),
                        searchUserDetail.getLopId(), searchUserDetail.getNganh()
                );
    }

    public List<TongSoNganh> getAllThongSo() {
        List<TongSoNganh> tongSoNganhs = new ArrayList<>();
        String nganh = "NGANH";
        String gioiTinh = "GIOI_TINH";
        List<ThongSo> listNganhs = thongSoService.findAllByLoai(nganh);
        List<ThongSo> listGioiTinhs = thongSoService.findAllByLoai(gioiTinh);

        for (ThongSo thongSo : listNganhs) {
            TongSoNganh tongSoNganh = new TongSoNganh();
            tongSoNganh.setId(thongSo.getId());
            tongSoNganh.setDienGiai(thongSo.getTen());
            tongSoNganh.setGiaTri(thongSo.getGiaTri());
            tongSoNganh.setLoai(nganh);
            tongSoNganh.setSoLuong(userDetailRepository.countAllByNganh(nganh));

            tongSoNganhs.add(tongSoNganh);
        }

        for (ThongSo thongSo : listGioiTinhs) {
            TongSoNganh tongSoNganh = new TongSoNganh();
            tongSoNganh.setId(thongSo.getId());
            tongSoNganh.setDienGiai(thongSo.getTen());
            tongSoNganh.setGiaTri(thongSo.getGiaTri());
            tongSoNganh.setLoai(gioiTinh);

            tongSoNganhs.add(tongSoNganh);
        }

        return tongSoNganhs;
    }
}
