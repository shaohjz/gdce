package com.isscollege.gdce.domain;

public class Advertisement {
    //�������id
    private int id;
    //��ҵ��������
    private int companyId;
    //���λ 1-4
    private int position;
    //����
    private String email;
    //���ͼƬ���·����/imgs/ads/��ҵ��������+ʱ�����
    private String adsImgPath;
    //��泬����ַ
    private String adsURL;
    //��ע
    private String note;
    //���Ͷ��ʱ��ʱ��
    private String releaseDate;
    //����ֹʱ��
    private String endDate;
    //���
    private double money;
    //������״̬ 0-����� 1-ͨ�� 2-δͨ��
    private int reviewState;

    //�������Ե�set��get

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdsImgPath() {
        return adsImgPath;
    }

    public void setAdsImgPath(String adsImgPath) {
        this.adsImgPath = adsImgPath;
    }

    public String getAdsURL() {
        return adsURL;
    }

    public void setAdsURL(String adsURL) {
        this.adsURL = adsURL;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getReviewState() {
        return reviewState;
    }

    public void setReviewState(int reviewState) {
        this.reviewState = reviewState;
    }
}
