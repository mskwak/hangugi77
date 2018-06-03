package com.daou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "neros_card_sync")
public class CardSync {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private boolean isCompleted = false;

	private String bankCode;
	private String cardNo;
	private Long apprSeq;
	private String apprNo;
	private String apprDate;
	private String apprTime;
	private Double apprAmt;
	private Double apprTax;
	private String halbu;
	private String chainId;
	private String chainName;
	private String chainCode;
	private String chainType;
	private String cancelYn;
	private String buyingDist;
	private String deductYn;
	private String insDatetime;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Long getApprSeq() {
		return apprSeq;
	}
	public void setApprSeq(Long apprSeq) {
		this.apprSeq = apprSeq;
	}
	public String getApprNo() {
		return apprNo;
	}
	public void setApprNo(String apprNo) {
		this.apprNo = apprNo;
	}
	public String getApprDate() {
		return apprDate;
	}
	public void setApprDate(String apprDate) {
		this.apprDate = apprDate;
	}
	public String getApprTime() {
		return apprTime;
	}
	public void setApprTime(String apprTime) {
		this.apprTime = apprTime;
	}
	public Double getApprAmt() {
		return apprAmt;
	}
	public void setApprAmt(Double apprAmt) {
		this.apprAmt = apprAmt;
	}
	public Double getApprTax() {
		return apprTax;
	}
	public void setApprTax(Double apprTax) {
		this.apprTax = apprTax;
	}
	public String getHalbu() {
		return halbu;
	}
	public void setHalbu(String halbu) {
		this.halbu = halbu;
	}
	public String getChainId() {
		return chainId;
	}
	public void setChainId(String chainId) {
		this.chainId = chainId;
	}
	public String getChainName() {
		return chainName;
	}
	public void setChainName(String chainName) {
		this.chainName = chainName;
	}
	public String getChainCode() {
		return chainCode;
	}
	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}
	public String getChainType() {
		return chainType;
	}
	public void setChainType(String chainType) {
		this.chainType = chainType;
	}
	public String getCancelYn() {
		return cancelYn;
	}
	public void setCancelYn(String cancelYn) {
		this.cancelYn = cancelYn;
	}
	public String getBuyingDist() {
		return buyingDist;
	}
	public void setBuyingDist(String buyingDist) {
		this.buyingDist = buyingDist;
	}
	public String getDeductYn() {
		return deductYn;
	}
	public void setDeductYn(String deductYn) {
		this.deductYn = deductYn;
	}
	public String getInsDatetime() {
		return insDatetime;
	}
	public void setInsDatetime(String insDatetime) {
		this.insDatetime = insDatetime;
	}
}
