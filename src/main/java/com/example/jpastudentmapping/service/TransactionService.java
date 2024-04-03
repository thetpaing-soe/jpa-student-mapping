package com.example.jpastudentmapping.service;

import com.example.jpastudentmapping.dao.EmployeeDao;
import com.example.jpastudentmapping.dao.ProvinceDao;
import com.example.jpastudentmapping.entity.Employee;
import com.example.jpastudentmapping.entity.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final ProvinceDao provinceDao;
    private final EmployeeDao employeeDao;

    public void deleteAllEmployee() {
        employeeDao.deleteAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createDB() {

        Province province1 = new Province("NO");
        Province province2 = new Province("SO");

        Employee e1 = new Employee("Thaw Thaw", "Htun Zin", "htunzin@gmail.com", 2000);
        Employee e2 = new Employee("Thu Thu", "Hnin Wai", "thuthu@gmail.com", 4000);

        provinceDao.save(province1);
        provinceDao.save(province2);

        employeeDao.save(e1);
        employeeDao.save(e2);

        throw new RuntimeException();
    }
}
