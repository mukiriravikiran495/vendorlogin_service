package com.shifting_customers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.model.From_office_details;
import com.shifting_customers.model.Office_shifting_details;
import com.shifting_customers.model.To_office_details;

@Repository("Office_shifting_details_dao")
@Transactional
public class Office_shifting_details_daoImpl implements Office_shifting_details_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Office_shifting_details> getalllist() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Office_shifting_details");
		List<Office_shifting_details> list = query.list();
		if( list.isEmpty()) {
			return null;
		}
		else {
			return list;
		}
	}

	@Override
	public String create(Office_shifting_details val) {
		Session session = sessionFactory.getCurrentSession();
		Office_shifting_details office_shifting_details = new Office_shifting_details();
		office_shifting_details.setOffice_shifting_details_id(val.getOffice_shifting_details_id());
		office_shifting_details.setFromlocation(val.getFromlocation());
		office_shifting_details.setTolocation(val.getTolocation());
		session.save(office_shifting_details);
		
		From_office_details from_office_details = new From_office_details();
		from_office_details.setAppointment_date(val.getFrom_office_details().getAppointment_date());
		from_office_details.setFloor(val.getFrom_office_details().getFloor());
		from_office_details.setFrom_office_details_id(val.getFrom_office_details().getFrom_office_details_id());
		from_office_details.setOffice_shifting_details(office_shifting_details);
		from_office_details.setPickup_contact(val.getFrom_office_details().getPickup_contact());
		from_office_details.setPickup_date(val.getFrom_office_details().getPickup_date());
		from_office_details.setPickupname(val.getFrom_office_details().getPickupname());
		from_office_details.setService_elevator(val.getFrom_office_details().getService_elevator());
		session.save(from_office_details);
		
		To_office_details to_office_details = new To_office_details();
		to_office_details.setDrop_contact(val.getTo_office_details().getDrop_contact());
		to_office_details.setDrop_date(val.getTo_office_details().getDrop_date());
		to_office_details.setDropname(val.getTo_office_details().getDropname());
		to_office_details.setFloor(val.getTo_office_details().getFloor());
		to_office_details.setOffice_shifting_details(office_shifting_details);
		to_office_details.setService_elevator(val.getTo_office_details().getService_elevator());
		to_office_details.setTo_office_details_id(val.getTo_office_details().getTo_office_details_id());
		session.save(to_office_details);
		
		return "Created ..!!";
	}

}
