package DAO.IPL;

import java.util.List;

import DAO.addGoods;
import Do.commodity;

public class addGoodsDao implements addGoods{
      
	private  static List<commodity> goods;

	public List<commodity> getGoods() {
		return goods;
	}

	
	public void setGoods(List<commodity> goods) {
		this.goods = goods;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
