package com.shifting_customers.service;

import java.util.List;

import com.shifting_customers.model.Reviews;

public interface Reviews_service {

	List<Reviews> getallreviews(long user_id);

}
