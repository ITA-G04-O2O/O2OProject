package vo.helper;

import vo.UserVo;

import com.g04.o2o.entity.User;

public class UserHelper {

	public static UserVo getUserVo(User user) {
		
		UserVo vo=new UserVo(user.getNickName(),user.getTel(),user.getBlance());
		return vo;
	}

}
