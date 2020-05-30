package com.sun.service.impl.customer;

import com.sun.entity.customer.GloryUser;
import com.sun.repository.dao.customer.GloryUserDAO;
import com.sun.service.customer.UserService;
import com.sun.util.ResultVOUtil;
import com.sun.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * liuzhanqiang
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    GloryUserDAO gloryUserDAO;


    //检验是否存在账户密码
    @Override
    public int checkUser(String userName, String userPwd) {
        //得到md5
        String passMd5 = md5(userPwd);

        return gloryUserDAO.selectuser(userName,passMd5);
    }

    @Override
    public ResultVO adduser(GloryUser gloryUser) {
        //随机生成uuid
        UUID uuid = UUID.randomUUID();
        //最终要存入的数据
        String id = uuid.toString().replace("-", "");

        System.out.println("生成的:" + id);
        gloryUser.setId(id);
        String name = gloryUser.getUsername();
        String phone = gloryUser.getPhone();
        String email = gloryUser.getEmail();

        //密码md5加密
        String pass = gloryUser.getPass();
        String passadd = md5(pass);

        //查询name是否存在
        int num = gloryUserDAO.selectname(name);
        if (num != 1) {
            gloryUserDAO.adduser(id, name, phone, passadd, email);
            int numOne = gloryUserDAO.selectname(name);
            if (numOne == 1) {
                return ResultVOUtil.success("添加成功");
            }
            return ResultVOUtil.error("系统错误");
        }
        return ResultVOUtil.error("用户名存在,请您更换一个名字");
    }

    public static String md5(String inputPass) {
        String md5big = DigestUtils.md5DigestAsHex(inputPass.getBytes());
        String md = formPassToDBPass(inputPassToFormPass(md5big, salt), salt);
        String passAdd = formPassToDBPass(inputPassToFormPass(md, salt), salt);

        return DigestUtils.md5DigestAsHex(passAdd.getBytes());
    }


    private static final String salt = "SunShiJiTuAn";

    public static String inputPassToFormPass(String inputPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return str;
    }

    public static String formPassToDBPass(String formPass, String saltDB) {
        String str = "" + saltDB.charAt(0) + saltDB.charAt(2) + formPass + saltDB.charAt(5) + saltDB.charAt(4);
        return str;
    }

//    public static void main(String[] args) {
//        System.out.println(inputPassToFormPass("123456", salt));//d3b1294a61a07da9b49b6e22b2cbd7f9
//        System.out.println(formPassToDBPass(inputPassToFormPass("123456", salt), salt));//b7797cce01b4b131b433b6acf4add449
//    }


//    public static String getMD5(String pass){
//        String sunshi = "sunshi";
//        String jituan = "jituan";
//        int num = 520;
//        String passadd = sunshi+pass+jituan+num;
//        return passadd;
//    }
}