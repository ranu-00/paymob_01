package com.innovate.paymob.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymob.common.paymob_common.bucketlistmodel.BucketListDataModel;

@Repository
public interface BucketListRepo extends JpaRepository<BucketListDataModel, Long> {

}
