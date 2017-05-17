package fr.oodyn.posinterface.delegate;



import java.util.List;

import fr.oodyn.posinterface.domain.User;
import fr.oodyn.posinterface.locator.ServiceLocator;
import fr.oodyn.posinterface.services.gestion.user.UserServicesRemote;



public class GestionUserDelegate {

	static UserServicesRemote remote;
	private static final String jndi="posmod/UserServices!fr.oodyn.posinterface.services.gestion.user.UserServicesRemote"; 

	private static UserServicesRemote getProxy(){
		return (UserServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public  static Boolean doAddUser(User user){
	return getProxy().addUser(user);
	
}
	
	public  static Boolean doUpdateUser(User user){
		return getProxy().updateUser(user);
		
	}
	
	public  static Boolean doDeleteUser(User user){
		return getProxy().deleteUser(user);
		
	}
	
	public  static User doFindUserById(Integer idUser)
	{
		return getProxy().findUserById(idUser);
	}
	public  static List<User> doFindAllUsers()
	{
		return getProxy().findAllUsers();
	}
	
	
	public static User doAuthentificate(String login,String pwd){
		return getProxy().authentificate(login, pwd);
	}
	public static User doFindUserByUsername(String name){
		return getProxy().findUserByUsername(name);
	}
	
	public  static List<User> dofindParticipateOrNot(String participate)
	{
		return getProxy().findParticipateOrNot(participate);
	}
	public  static Integer doFindAllUsersBylevel(String level)
	{
		return getProxy().findUserByLevel(level);
	}
	
}
