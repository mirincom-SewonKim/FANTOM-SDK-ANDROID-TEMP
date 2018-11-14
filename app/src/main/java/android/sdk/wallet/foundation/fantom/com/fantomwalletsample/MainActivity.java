package android.sdk.wallet.foundation.fantom.com.fantomwalletsample;

import android.content.DialogInterface;
import android.sdk.wallet.foundation.fantom.com.fantom_android_wallet_sdk.FantomObject;
import android.sdk.wallet.foundation.fantom.com.fantom_android_wallet_sdk.FantomWallet;
import android.sdk.wallet.foundation.fantom.com.fantom_android_wallet_sdk.OnResponseCb;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.sdk.wallet.foundation.fantom.com.fantom_android_wallet_sdk.FantomDefine.interfaceType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etId = null;
    private EditText etPW = null;

    private Button btnAuth = null;
    private Button btnRequest = null;

    private TextView btnMenu = null;
    private TextView txtResult = null;

    private LinearLayout layoutApi = null;

    private LinearLayout layout002 = null;
    private EditText etPageNum002 = null;
    private EditText etPageCnt002 = null;
    private EditText etSearchName002 = null;
    private EditText etCode002 = null;

    private LinearLayout layout003 = null;
    private EditText etFID003 = null;

    private LinearLayout layout004 = null;
    private EditText etFID004 = null;
    private EditText etPageNum004 = null;
    private EditText etPageCnt004 = null;

    private LinearLayout layout005 = null;
    private EditText etFID005 = null;
    private EditText etPageNum005 = null;
    private EditText etPageCnt005 = null;

    private LinearLayout layout006 = null;
    private EditText etFID006 = null;
    private EditText etPageNum006 = null;
    private EditText etPageCnt006 = null;
    private EditText etRewardType006 = null;

    private LinearLayout layout007 = null;
    private EditText etFID007 = null;
    private EditText etPageNum007 = null;
    private EditText etPageCnt007 = null;
    private EditText etPenaltyType007 = null;

    private LinearLayout layout008 = null;
    private EditText etFID008 = null;
    private EditText etPageNum008 = null;
    private EditText etPageCnt008 = null;
    private EditText etPayType008 = null;

    private LinearLayout layout009 = null;
    private EditText etFID009 = null;
    private EditText etPayType009 = null;

    private LinearLayout layout010 = null;
    private EditText etFID010 = null;
    private EditText etCoinType010 = null;
    private EditText etCurrencyType010 = null;

    private LinearLayout layout011 = null;
    private EditText etFID011 = null;
    private EditText etCurrencyCode011 = null;
    private EditText etAmount011 = null;
    private EditText etFee011 = null;
    private EditText etProcSpeed011 = null;
    private EditText etWalletAddr011 = null;
    private TextView txtCount011 = null;
    private EditText etCalcTargetID011 = null;
    private EditText etRewardMemo011 = null;
    private Button btnAddReward011 = null;
    private EditText etMemo011 = null;
    private ArrayList<HashMap<String, Object>> rewardArrayList011 = new ArrayList<>();

    private LinearLayout layout012 = null;
    private EditText etFID012 = null;
    private EditText etWalletAddr012 = null;
    private TextView txtCount012 = null;
    private EditText etCalcTargetID012 = null;
    private EditText etRewardMemo012 = null;
    private Button btnAddReward012 = null;
    private ArrayList<HashMap<String, Object>> rewardArrayList012 = new ArrayList<>();


    private LinearLayout layout013 = null;
    private EditText etFID013 = null;
    private EditText etTID013 = null;
    private EditText etAmount013 = null;

    private LinearLayout layout014 = null;
    private EditText etFID014 = null;
    private EditText etTID014 = null;

    private LinearLayout layout015 = null;
    private EditText etUID015 = null;
    private EditText etUPWD015 = null;

    private LinearLayout layout016 = null;
    private EditText etLoginAuthKey016 = null;
    private EditText etCoinType016 = null;

    private LinearLayout layout017 = null;
    private EditText etLoginAuthKey017 = null;
    private EditText etCoinType017 = null;

    private LinearLayout layout018 = null;
    private EditText etLoginAuthKey018 = null;
    private EditText etCoinType018 = null;
    private EditText etReceiverAddr018 = null;
    private EditText etAmount018 = null;
    private EditText etFee018 = null;
    private EditText etProcSpeedCd018 = null;

    private LinearLayout layout019 = null;
    private EditText etLoginAuthKey019 = null;
    private EditText etCoinType019 = null;
    private EditText etAmount019 = null;
    private EditText etFee019 = null;
    private EditText etConvertCoinType019 = null;
    private EditText etProcSpeedCd019 = null;

    private LinearLayout layout020 = null;
    private EditText etLoginAuthKey020 = null;
    private EditText etPageNum020 = null;
    private EditText etPageCnt020 = null;
    private EditText etCoinType020 = null;

    private ProgressBar progressBar = null;

    private static final String[] menus = {
            "IF-FTM-WL-002",
            "IF-FTM-WL-003",
            "IF-FTM-WL-004",
            "IF-FTM-WL-005",
            "IF-FTM-WL-006",
            "IF-FTM-WL-007",
            "IF-FTM-WL-008",
            "IF-FTM-WL-009",
            "IF-FTM-WL-010",
            "IF-FTM-WL-011",
            "IF-FTM-WL-012",
            "IF-FTM-WL-013",
            "IF-FTM-WL-014",
            "IF-FTM-WL-015",
            "IF-FTM-WL-016",
            "IF-FTM-WL-017",
            "IF-FTM-WL-018",
            "IF-FTM-WL-019",
            "IF-FTM-WL-020"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FantomWallet.shared().setConfig(this, false, false);

        setUiResource();
    }

    private void setUiResource() {
        etId = findViewById(R.id.et_id);
        etPW = findViewById(R.id.et_pw);

        btnAuth = findViewById(R.id.btn_auth);
        btnAuth.setOnClickListener(this);

        btnMenu = findViewById(R.id.btn_menu);
        btnMenu.setEnabled(false);
        btnMenu.setOnClickListener(this);

        btnRequest = findViewById(R.id.btn_request);

        txtResult = findViewById(R.id.txt_result);

        layoutApi = findViewById(R.id.layout_api);

        layout002 = findViewById(R.id.layout_002);
        etPageNum002 = findViewById(R.id.et_page_num_002);
        etPageCnt002 = findViewById(R.id.et_page_cnt_002);
        etSearchName002 = findViewById(R.id.et_search_name_002);
        etCode002 = findViewById(R.id.et_code_002);

        layout003 = findViewById(R.id.layout_003);
        etFID003 = findViewById(R.id.et_franchise_id_003);

        layout004 = findViewById(R.id.layout_004);
        etFID004 = findViewById(R.id.et_franchise_id_004);
        etPageNum004 = findViewById(R.id.et_page_num_004);
        etPageCnt004 = findViewById(R.id.et_page_cnt_004);

        layout005 = findViewById(R.id.layout_005);
        etFID005 = findViewById(R.id.et_franchise_id_005);
        etPageNum005 = findViewById(R.id.et_page_num_005);
        etPageCnt005 = findViewById(R.id.et_page_cnt_005);

        layout006 = findViewById(R.id.layout_006);
        etFID006 = findViewById(R.id.et_franchise_id_006);
        etPageNum006 = findViewById(R.id.et_page_num_006);
        etPageCnt006 = findViewById(R.id.et_page_cnt_006);
        etRewardType006 = findViewById(R.id.et_reward_type_006);

        layout007 = findViewById(R.id.layout_007);
        etFID007 = findViewById(R.id.et_franchise_id_007);
        etPageNum007 = findViewById(R.id.et_page_num_007);
        etPageCnt007 = findViewById(R.id.et_page_cnt_007);
        etPenaltyType007 = findViewById(R.id.et_penalty_type_007);

        layout008 = findViewById(R.id.layout_008);
        etFID008 = findViewById(R.id.et_franchise_id_008);
        etPageNum008 = findViewById(R.id.et_page_num_008);
        etPageCnt008 = findViewById(R.id.et_page_cnt_008);
        etPayType008 = findViewById(R.id.et_pay_type_008);

        layout009 = findViewById(R.id.layout_009);
        etFID009 = findViewById(R.id.et_franchise_id_009);
        etPayType009 = findViewById(R.id.et_pay_type_009);

        layout010 = findViewById(R.id.layout_010);
        etFID010 = findViewById(R.id.et_franchise_id_010);
        etCoinType010 = findViewById(R.id.et_coin_type_010);
        etCurrencyType010 = findViewById(R.id.et_currency_type_010);

        layout011 = findViewById(R.id.layout_011);
        etFID011 = findViewById(R.id.et_franchise_id_011);
        etCurrencyCode011 = findViewById(R.id.et_currency_code_011);
        etAmount011 = findViewById(R.id.et_amount_011);
        etFee011 = findViewById(R.id.et_fee_011);
        etProcSpeed011 = findViewById(R.id.et_proc_speed_011);
        etWalletAddr011 = findViewById(R.id.et_wallet_addr_011);
        txtCount011 = findViewById(R.id.txt_count_011);
        etCalcTargetID011 = findViewById(R.id.et_calc_target_id_011);
        etRewardMemo011 = findViewById(R.id.et_reward_memo_011);
        btnAddReward011 = findViewById(R.id.btn_add_reward_011);
        btnAddReward011.setOnClickListener(this);
        etMemo011 = findViewById(R.id.et_memo_011);


        layout012 = findViewById(R.id.layout_012);
        etFID012 = findViewById(R.id.et_franchise_id_012);
        etWalletAddr012 = findViewById(R.id.et_wallet_addr_012);
        etCalcTargetID012 = findViewById(R.id.et_calc_target_id_012);
        txtCount012 = findViewById(R.id.txt_count_012);
        etRewardMemo012 = findViewById(R.id.et_reward_memo_012);
        btnAddReward012 = findViewById(R.id.btn_add_reward_012);
        btnAddReward012.setOnClickListener(this);

        layout013 = findViewById(R.id.layout_013);
        etFID013 = findViewById(R.id.et_franchise_id_013);
        etTID013 = findViewById(R.id.et_transaction_id_013);
        etAmount013 = findViewById(R.id.et_cancel_amount_013);


        layout014 = findViewById(R.id.layout_014);
        etFID014 = findViewById(R.id.et_franchise_id_014);
        etTID014 = findViewById(R.id.et_transaction_id_014);

        layout015 = findViewById(R.id.layout_015);
        etUID015 = findViewById(R.id.et_user_id_015);
        etUPWD015 = findViewById(R.id.et_user_password_015);

        layout016 = findViewById(R.id.layout_016);
        etLoginAuthKey016 = findViewById(R.id.et_login_auth_key_016);
        etCoinType016 = findViewById(R.id.et_coin_type_016);

        layout017 = findViewById(R.id.layout_017);
        etLoginAuthKey017 = findViewById(R.id.et_login_auth_key_017);
        etCoinType017 = findViewById(R.id.et_login_auth_key_017);

        layout018 = findViewById(R.id.layout_018);
        etLoginAuthKey018 = findViewById(R.id.et_login_auth_key_018);
        etCoinType018 = findViewById(R.id.et_coin_type_018);
        etReceiverAddr018 = findViewById(R.id.et_receiveraddr_018);
        etAmount018 = findViewById(R.id.et_amount_018);
        etFee018 = findViewById(R.id.et_fee_018);
        etProcSpeedCd018 = findViewById(R.id.et_procspeedcd_018);

        layout019 = findViewById(R.id.layout_019);
        etLoginAuthKey019 = findViewById(R.id.et_login_auth_key_019);
        etCoinType019 = findViewById(R.id.et_coin_type_019);
        etAmount019 = findViewById(R.id.et_amount_019);
        etFee019 = findViewById(R.id.et_fee_019);
        etConvertCoinType019 = findViewById(R.id.et_convertCoinType_019);
        etProcSpeedCd019 = findViewById(R.id.et_procspeedcd_019);

        layout020 = findViewById(R.id.layout_020);
        etLoginAuthKey020 = findViewById(R.id.et_login_auth_key_020);
        etPageNum020 = findViewById(R.id.et_page_num_020);
        etPageCnt020 = findViewById(R.id.et_page_cnt_020);
        etCoinType020 = findViewById(R.id.et_cointype_020);

        progressBar = findViewById(R.id.progress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_auth : {
                FantomObject fantomObject = new FantomObject();
                try {
                    fantomObject.put("clientId", etId.getText().toString());
                    fantomObject.put("clientSecret", etPW.getText().toString());
                    fantomObject.put("reqDate", getCurrentDate());
                } catch (Exception e) {

                }

                progressBar.setVisibility(View.VISIBLE);
                FantomWallet.shared().reqApi(interfaceType.clientAuth, fantomObject.toString(), new OnResponseCb() {
                    @Override
                    public void onResponse(String retCode, String resData) {
                        try {
                            FantomObject object = FantomObject.stringToObject(resData, FantomWallet.shared().isDebugMode());
                            String tokenType = (String) object.get("tokenType");
                            String accessToken = (String) object.get("accessToken");
                            FantomWallet.shared().setAccecToken(tokenType, accessToken);

                            btnMenu.setEnabled(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(String retCode, String errMessage) {
                        progressBar.setVisibility(View.GONE);
                    }
                });
            } break;

            case R.id.btn_menu : {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setItems(menus, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setLayoutVisiable(which);
                        switch (which) {
                            case 0: { // IF-FTM-WL-002
                                btnMenu.setText("IF-FTM-WL-002");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("pageNum", Integer.parseInt(etPageNum002.getText().toString()));
                                            fantomObject.put("pageCnt", Integer.parseInt(etPageCnt002.getText().toString()));
                                            fantomObject.put("franchiseSearchNm", etSearchName002.getText().toString());
                                            fantomObject.put("franchiseCd", etCode002.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.franchiseList, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 1: { // IF-FTM-WL-003
                                btnMenu.setText("IF-FTM-WL-003");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID003.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.franchiseDetail, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 2: { // IF-FTM-WL-004
                                btnMenu.setText("IF-FTM-WL-004");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID004.getText().toString());
                                            fantomObject.put("pageNum", Integer.parseInt(etPageNum004.getText().toString()));
                                            fantomObject.put("pageCnt", Integer.parseInt(etPageCnt004.getText().toString()));
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.rewardPolicyList, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 3: { // IF-FTM-WL-005
                                btnMenu.setText("IF-FTM-WL-005");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID005.getText().toString());
                                            fantomObject.put("pageNum", Integer.parseInt(etPageNum005.getText().toString()));
                                            fantomObject.put("pageCnt", Integer.parseInt(etPageCnt005.getText().toString()));
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.penaltyPolicyList, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 4: { // IF-FTM-WL-006
                                btnMenu.setText("IF-FTM-WL-006");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID006.getText().toString());
                                            fantomObject.put("pageNum", Integer.parseInt(etPageNum006.getText().toString()));
                                            fantomObject.put("pageCnt", Integer.parseInt(etPageCnt006.getText().toString()));
                                            fantomObject.put("rewardType", etRewardType006.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.rewardList, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 5: { // IF-FTM-WL-007
                                btnMenu.setText("IF-FTM-WL-007");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID007.getText().toString());
                                            fantomObject.put("pageNum", Integer.parseInt(etPageNum007.getText().toString()));
                                            fantomObject.put("pageCnt", Integer.parseInt(etPageCnt007.getText().toString()));
                                            fantomObject.put("penaltyType", etPenaltyType007.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.penaltyList, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 6: { // IF-FTM-WL-008
                                btnMenu.setText("IF-FTM-WL-008");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID008.getText().toString());
                                            fantomObject.put("pageNum", Integer.parseInt(etPageNum008.getText().toString()));
                                            fantomObject.put("pageCnt", Integer.parseInt(etPageCnt008.getText().toString()));
                                            fantomObject.put("payType", etPayType008.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.payList, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 7: { // IF-FTM-WL-009
                                btnMenu.setText("IF-FTM-WL-009");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID009.getText().toString());
                                            fantomObject.put("payType", etPayType009.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.payFee, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 8: { // IF-FTM-WL-010
                                btnMenu.setText("IF-FTM-WL-010");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID010.getText().toString());
                                            fantomObject.put("coinType", etCoinType010.getText().toString());
                                            fantomObject.put("targetCurrencyType", etCurrencyType010.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.marketPrice, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 9: { // IF-FTM-WL-011
                                btnMenu.setText("IF-FTM-WL-011");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
//                                        if(rewardArrayList011.size() == 0) {
//                                            HashMap<String, Object> hashMap = new HashMap<>();
//                                            hashMap.put("rewardCalcTargetRangeId", "");
//                                            hashMap.put("rewardMemo", "");
//                                            rewardArrayList011.add(hashMap);
//                                        }

                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID011.getText().toString());
                                            fantomObject.put("payCurrencyCd", etCurrencyCode011.getText().toString());
                                            fantomObject.put("payAmount", Integer.parseInt(etAmount011.getText().toString()));
                                            fantomObject.put("payFee", Integer.parseInt(etFee011.getText().toString()));
                                            fantomObject.put("payProcSpeed", etProcSpeed011.getText().toString());
                                            fantomObject.put("payWalletAddr", etWalletAddr011.getText().toString());
                                            fantomObject.put("rewardList", rewardArrayList011);
                                            fantomObject.put("payMemo", etMemo011.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.pay, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 10: { // IF-FTM-WL-012
                                btnMenu.setText("IF-FTM-WL-012");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
//                                        if(rewardArrayList012.size() == 0) {
//                                            HashMap<String, Object> hashMap = new HashMap<>();
//                                            hashMap.put("rewardCalcTargetRangeId", "");
//                                            hashMap.put("rewardMemo", "");
//                                            rewardArrayList012.add(hashMap);
//                                        }

                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID012.getText().toString());
                                            fantomObject.put("rewardReceiveWalletAddr", etWalletAddr012.getText().toString());
                                            fantomObject.put("rewardList", rewardArrayList012);
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.reward, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 11: { // IF-FTM-WL-013
                                btnMenu.setText("IF-FTM-WL-013");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID013.getText().toString());
                                            fantomObject.put("payTransactionId", etTID013.getText().toString());
                                            fantomObject.put("payCancelAmount", Integer.parseInt(etAmount013.getText().toString()));
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.payCancel, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 12: { // IF-FTM-WL-014
                                btnMenu.setText("IF-FTM-WL-014");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("franchiseId", etFID014.getText().toString());
                                            fantomObject.put("rewardTransactionId", etTID014.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        } catch (Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.rewardCancel, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 13: { // IF-FTM-WL-015
                                btnMenu.setText("IF-FTM-WL-015");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("userId", etUID015.getText().toString());
                                            fantomObject.put("userPw", etUPWD015.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        }catch(Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.userLogin, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 14: {
                                btnMenu.setText("IF-FTM-WL-016");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("loginAuthKey", etLoginAuthKey016.getText().toString());
                                            fantomObject.put("coinType", etCoinType016.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        }catch(Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.userHolding, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });

                                    }
                                });
                            } break;

                            case 15: {
                                btnMenu.setText("IF-FTM-WL-017");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("loginAuthKey", etLoginAuthKey017.getText().toString());
                                            fantomObject.put("coinType", etCoinType017.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        }catch(Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.userWalletAddr, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 16: {
                                btnMenu.setText("IF-FTM-WL-018");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("loginAuthKey", etLoginAuthKey018.getText().toString());
                                            fantomObject.put("coinType", etCoinType018.getText().toString());
                                            fantomObject.put("receiverAddr", etReceiverAddr018.getText().toString());
                                            fantomObject.put("amount", etAmount018.getText().toString());
                                            fantomObject.put("fee", etFee018.getText().toString());
                                            fantomObject.put("procSpeedCd", etProcSpeedCd018.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        }catch(Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.coinTransfer, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 17: {
                                btnMenu.setText("IF-FTM-WL-019");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("loginAuthKey", etLoginAuthKey019.getText().toString());
                                            fantomObject.put("coinType", etCoinType019.getText().toString());
                                            fantomObject.put("amount", etAmount019.getText().toString());
                                            fantomObject.put("fee", etFee019.getText().toString());
                                            fantomObject.put("convertCoinType", etConvertCoinType019.getText().toString());
                                            fantomObject.put("procSpeedCd", etProcSpeedCd019.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        }catch(Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.coinConvert, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;

                            case 18: {
                                btnMenu.setText("IF-FTM-WL-020");
                                btnRequest.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        FantomObject fantomObject = new FantomObject();
                                        try {
                                            fantomObject.put("loginAuthKey", etLoginAuthKey020.getText().toString());
                                            fantomObject.put("pageNum", etPageNum020.getText().toString());
                                            fantomObject.put("pageCnt", etPageCnt020.getText().toString());
                                            fantomObject.put("coinType", etCoinType020.getText().toString());
                                            fantomObject.put("reqDate", getCurrentDate());
                                        }catch(Exception e) {

                                        }

                                        FantomWallet.shared().reqApi(interfaceType.userTransferHist, fantomObject.toString(), new OnResponseCb() {
                                            @Override
                                            public void onResponse(String retCode, String resData) {
                                                txtResult.setText(resData);
                                            }

                                            @Override
                                            public void onError(String retCode, String errMessage) {
                                                txtResult.setText(String.format("errCode : %s, message : %s", retCode, errMessage));
                                            }
                                        });
                                    }
                                });
                            } break;
                        }

                        layoutApi.setVisibility(View.VISIBLE);

                        txtResult.setText("");
                        txtResult.setVisibility(View.VISIBLE);

                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            } break;

            case R.id.btn_add_reward_011 : {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("rewardCalcTargetRangeId", etCalcTargetID011.getText().toString());
                hashMap.put("rewardMemo", etRewardMemo011.getText().toString());
                rewardArrayList011.add(hashMap);

                if(rewardArrayList011 != null)
                    txtCount011.setText(String.valueOf(rewardArrayList011.size()));

                etCalcTargetID011.setText("");
                etRewardMemo011.setText("");
            } break;

            case R.id.btn_add_reward_012 : {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("rewardCalcTargetRangeId", etCalcTargetID012.getText().toString());
                hashMap.put("rewardMemo", etRewardMemo012.getText().toString());
                rewardArrayList012.add(hashMap);

                if(rewardArrayList012 != null)
                    txtCount012.setText(String.valueOf(rewardArrayList012.size()));

                etCalcTargetID012.setText("");
                etRewardMemo012.setText("");
            } break;
        }
    }

    private void setLayoutVisiable(int num) {
        layout002.setVisibility(num == 0 ? View.VISIBLE : View.GONE);
        layout003.setVisibility(num == 1 ? View.VISIBLE : View.GONE);
        layout004.setVisibility(num == 2 ? View.VISIBLE : View.GONE);
        layout005.setVisibility(num == 3 ? View.VISIBLE : View.GONE);
        layout006.setVisibility(num == 4 ? View.VISIBLE : View.GONE);
        layout007.setVisibility(num == 5 ? View.VISIBLE : View.GONE);
        layout008.setVisibility(num == 6 ? View.VISIBLE : View.GONE);
        layout009.setVisibility(num == 7 ? View.VISIBLE : View.GONE);
        layout010.setVisibility(num == 8 ? View.VISIBLE : View.GONE);
        layout011.setVisibility(num == 9 ? View.VISIBLE : View.GONE);
        layout012.setVisibility(num == 10 ? View.VISIBLE : View.GONE);
        layout013.setVisibility(num == 11 ? View.VISIBLE : View.GONE);
        layout014.setVisibility(num == 12 ? View.VISIBLE : View.GONE);
        layout015.setVisibility(num == 13 ? View.VISIBLE : View.GONE);
        layout016.setVisibility(num == 14 ? View.VISIBLE : View.GONE);
        layout017.setVisibility(num == 15 ? View.VISIBLE : View.GONE);
        layout018.setVisibility(num == 16 ? View.VISIBLE : View.GONE);
        layout019.setVisibility(num == 17 ? View.VISIBLE : View.GONE);
        layout020.setVisibility(num == 18 ? View.VISIBLE : View.GONE);
    }

    public static String getCurrentDate()
    {
        long cur_millis = System.currentTimeMillis();

        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(cur_millis);
        String cur = formatter.format(calendar.getTime());
        return cur;
    }
}
