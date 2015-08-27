package vo.helper;

public class OrderStatusHelper {
	public static String getStatusDesc(Integer status){
		//1: user add order. 2:merchant received order. 3:merchant refused order. 4: order finished.
		switch (status) {
		case 1:
			return "�û��ύ����";
		case 2:
			return "������ȷ��";
		case 3:
			return "�̼Ҿܾ�����";
		case 4:
			return "�������";
		default:
			return "��״̬";
		}
	}
}
