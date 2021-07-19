package com.shifting_customers.dao;

import java.util.List;

import com.shifting_customers.model.Reviews;

public interface Reviews_dao {

	List<Reviews> getallreviews(long user_id);

}
