//package com.blogspot.danserlesgens.business.impl;
//
//import com.blogspot.danserlesgens.business.ICompanyNum;
//import com.blogspot.danserlesgens.dao.ICompanyNumDAO;
//import com.blogspot.danserlesgens.value.CompanyNumValue;
//
//import java.util.List;
//
//import static com.blogspot.danserlesgens.factory.DaoFactory.createCompanyNumDao;

//public class CompanyNumImpl implements ICompanyNum {
//    @Override
//    public boolean add(String name, int num) throws Exception {
//        boolean flag = isExist(name);
//        if (!flag){
//            ICompanyNumDAO cndo = createCompanyNumDao();
//            CompanyNumValue cnv = new CompanyNumValue();
//            cnv.setName(name);
//            cnv.setNum(num);
//            cndo.create(cnv);
//        }
//        return  flag;
//    }
//
//    @Override
//    public boolean delete(String name) throws Exception {
//        boolean flag = isExist(name);
//        if (flag){
//            ICompanyNumDAO cndo = createCompanyNumDao();
//            cndo.delete(cndo.findByName(name));
//        }
//        return  flag;
//    }
//
//    @Override
//    public boolean modify(String name, int num) throws Exception {
//        boolean flag = isExist(name);
//        if (flag){
//            ICompanyNumDAO cndo = createCompanyNumDao();
//            CompanyNumValue cnv = cndo.findByName(name);
////            cnv.setName(name);
//            cnv.setNum(num);
//            cndo.update(cnv);
//        }
//        return flag;
//    }
//
//    @Override
//    public List<CompanyNumValue> getListByName(String name) throws Exception {
//        ICompanyNumDAO cndo = createCompanyNumDao();
//        return cndo.findByName(name);
//    }
//
//    @Override
//    public boolean isExist(String name) throws Exception {
//        boolean flag = false;
//        ICompanyNumDAO cndo = createCompanyNumDao();
//        if (cndo.findByName(name).getName() != null){
//            flag = true;
//        }
//        return  flag;
//    }
//}
