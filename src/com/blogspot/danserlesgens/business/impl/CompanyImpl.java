package com.blogspot.danserlesgens.business.impl;

import com.blogspot.danserlesgens.business.ICompany;
import com.blogspot.danserlesgens.dao.ICompanyDAO;
import com.blogspot.danserlesgens.value.CompanyValue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.blogspot.danserlesgens.factory.DaoFactory.createCompanyDao;

public class CompanyImpl implements ICompany {
    @Override
    public boolean add(String name, String man, BigDecimal manCardId) throws Exception {
        boolean flag = isExist(name);
        if (!flag){
            ICompanyDAO cdo = createCompanyDao();
            CompanyValue cv = new CompanyValue();
            cv.setName(name);
            cv.setMan(man);
            cv.setManCardId(manCardId);
            cdo.create(cv);
        }
        return  flag;
    }

    @Override
    public boolean delete(String name) throws Exception {
        boolean flag = isExist(name);
        if (flag){
            ICompanyDAO cdo = createCompanyDao();
            cdo.delete(cdo.findByName(name));
        }
        return  flag;
    }

    @Override
    public boolean modify(String name, String man, BigDecimal manCardId) throws Exception {
        boolean flag = isExist(name);
        if (flag){
            ICompanyDAO cdo = createCompanyDao();
            CompanyValue cv = cdo.findByName(name);
            cv.setMan(man);
            cv.setManCardId(manCardId);
            cdo.update(cv);
        }
        return flag;
    }

    @Override
    public List<CompanyValue> getList() throws Exception {
        ICompanyDAO cdo = createCompanyDao();
        return cdo.findAll();
    }

    @Override
    public List<CompanyValue> getPageList(int pageNumber, int pageSize, String order) throws Exception {
        ICompanyDAO cdo = createCompanyDao();
        if (order == null || order.equals("")){
            return cdo.findByPage(pageNumber,pageSize);
        }
        else {
            return cdo.findByPage(pageNumber,pageSize,order);
        }
    }

    @Override
    public CompanyValue getCompany(String name) throws Exception {
        ICompanyDAO Cdo = createCompanyDao();
        return Cdo.findByName(name);
    }

    @Override
    public boolean isExist(String name) throws Exception {
        boolean flag = false;
        ICompanyDAO cdo = createCompanyDao();
        if (cdo.findByName(name).getName() != null){
            flag = true;
        }
        return  flag;
    }

    @Override
    public int getPageListNumber() throws Exception {
        ICompanyDAO cdo = createCompanyDao();
        return cdo.listNumber();
    }

    @Override
    public String getListJson(List<CompanyValue> pageList) throws Exception {
        ICompanyDAO cdo = createCompanyDao();
        String companysJson = "    {  \n" +
                "        \"total\": "+cdo.listNumber()+",   \n" +
                "        \"rows\": [  \n";
        for (CompanyValue companyValue : pageList) {
            companysJson += "{\n" +
                    "            \"name\": \""+companyValue.getName()+"\",\n" +
                    "            \"man\": \""+companyValue.getMan()+"\",\n" +
                    "            \"manCardId\": \""+companyValue.getManCardId()+"\"  \n" +
                    "        },";
        }
        companysJson = companysJson.substring(0,companysJson.length()-1);
        companysJson+=
                "        ]  \n" +
                        "    }  ";
        return companysJson;
    }

    @Override
    public double getTotalPay(String name) throws Exception {
        boolean flag = isExist(name);
        double payment = -1;
        if (flag){
            ICompanyDAO cdo = createCompanyDao();
            CompanyValue cv = cdo.findByName(name);
            payment = cdo.totalPay(cv);
        }
        return  payment;
    }

    @Override
    public Map<String, Integer> getPossession() throws Exception {
        ICompanyDAO cdo = createCompanyDao();
        return cdo.possession();
    }

    @Override
    public String getPossessionJson(Map<String, Integer> possession) throws Exception {
        String possessionJson = "{\n" +
                "\t\"possession\":[";
        for (String comName: possession.keySet()) {
            possessionJson += "{\n" +
                    "\t\t\"comName\":\""+comName+"\",\n" +
                    "\t\t\"num\":"+(int)possession.get(comName)+"\n" +
                    "\t},";
        }
        possessionJson = possessionJson.substring(0,possessionJson.length()-1);
        possessionJson+="]\n" +
                "}";
        return possessionJson;
    }

}