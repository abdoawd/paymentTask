package com.example.paymentTask.repository;

import com.example.paymentTask.entity.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository  extends CrudRepository<Card, String> {


    @Query("SELECT new Card(c.pan,c.status) FROM Card c where c.pan =:pan")
    public Optional<Card> findCardStatusByPan(@Param("pan") String pan);

    double getBalanceByPan(String pan);

    void deductBalance(String pan, double transactionAmount);
}
