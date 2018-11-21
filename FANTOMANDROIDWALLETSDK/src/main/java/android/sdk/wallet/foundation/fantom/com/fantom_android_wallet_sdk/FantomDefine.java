package android.sdk.wallet.foundation.fantom.com.fantom_android_wallet_sdk;

import android.util.Log;

public class FantomDefine {
    public enum interfaceType {
        /**
         * clientAuth
         * interface ID : F-FTM-WL-001
         * client auth interface
         * @param clientId(mandatory) : client id
         * @param clientPw(mandatory) : client password
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        clientAuth,

        /**
         * franchiseList
         * interface ID : IF-FTM-WL-002
         * franchise List interface
         * @param pageNum(mandatory) : page number
         * @param pageCnt(mandatory) : page count
         * @param franchiseSearchNm(optional) : franchise name
         * @param franchiseCd(mandatory) : franchise code
        ex) 000:all, 100:company direct store ,200:franchise, 999:head office
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        franchiseList,

        /**
         * franchiseDetail
         * interface ID : IF-FTM-WL-003
         * franchise detail info interface
         * @param franchiseId(mandatory) : franchise id
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        franchiseDetail,

        /**
         * rewardPolicyList
         * interface ID : IF-FTM-WL-004
         * franchise reward policy list interface
         * @param franchiseId(mandatory) : franchise id
         * @param pageNum(mandatory) : page number
         * @param pageCnt(mandatory) : page count
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        rewardPolicyList,

        /**
         * penaltyPolicyList
         * interface ID : IF-FTM-WL-005
         * franchise penalty plicy list interface
         * @param franchiseId(mandatory) : franchise id
         * @param pageNum(mandatory) : page number
         * @param pageCnt(mandatory) : page count
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        penaltyPolicyList,

        /**
         * penaltyPolicyList
         * interface ID : IF-FTM-WL-006
         * franchise reward list interface
         * @param franchiseId(mandatory) : franchise id
         * @param pageNum(mandatory) : page number
         * @param pageCnt(mandatory) : page count
         * @param rewardType(mandatory) : reward type
        ex) 100:FTC reward, 200:FTP reward, 300:FTW reward
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        rewardList,

        /**
         * penaltyList
         * interface ID : IF-FTM-WL-007
         * franchise penalty list interface
         * @param franchiseId(mandatory) : franchise id
         * @param pageNum(mandatory) : page number
         * @param pageCnt(mandatory) : page count
         * @param penaltyType(mandatory) : penalty type
        ex) 100:FTC penalty, 200:FTP penalty, 300:FTW penalty
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        penaltyList,

        /**
         * payList
         * interface ID : IF-FTM-WL-008
         * franchise payment list interface
         * @param franchiseId(mandatory) : franchise id
         * @param pageNum(mandatory) : page number
         * @param pageCnt(mandatory) : page count
         * @param payType(mandatory) : pay type
        ex) 100:FTC, 200:FTP, 300:FTW
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        payList,

        /**
         * payFee
         * interface ID : IF-FTM-WL-009
         * franchise payment fee interface
         * @param franchiseId(mandatory) : franchise id
         * @param payType(mandatory) : pay type
        ex) 100:FTC, 200:FTP, 300:FTW
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        payFee,

        /**
         * marketPrice
         * interface ID : IF-FTM-WL-010
         * coin market price interface
         * @param franchiseId(mandatory) : franchise id
         * @param coinType(mandatory) : coin type
        ex)100:FTC, 200:FTP, 300:FTW, KRW:korea won, USD:US dollar, RMB:china yuan
         * @param targetCurrencyType(mandatory) : target currency type
        ex)100:FTC, 200:FTP, 300:FTW, KRW:korea won, USD:US dollar, RMB:china yuan
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        marketPrice,

        /**
         * pay
         * interface ID : IF-FTM-WL-011
         * payment interface
         * @param franchiseId(mandatory) : franchise id
         * @param payCurrencyCd(mandatory) : pay currency code
        ex)100:FTC, 200:FTP, 300:FTW
         * @param payAmount(mandatory) : pay amount
         * @param payFee(mandatory) : pay fee
         * @param payProcSpeed(mandatory) : pay processing speed
        ex)100:slow, 200:usually, 300:fast
         * @param payWalletAddr(mandatory) : pay wallet address
         * @param rewardList(array)
        rewardCalcTargetRangeId(optional): target range ID
        rewardMemo(optional): memo
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        pay,

        /**
         * reward
         * interface ID : IF-FTM-WL-012
         * reward interface
         * @param franchiseId(mandatory) : franchise id
         * @param rewardReceiveWalletAddr(mandatory) : reward receive wallet address
         * @param rewardList(array)
        rewardCalcTargetRangeId(mandatory): target range ID
        rewardMemo(optional): memo
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        reward,

        /**
         * payCancel
         * interface ID : IF-FTM-WL-013
         * payment cancel interface
         * @param payTransactionId(mandatory) : payment transaction id
         * @param payCancelAmount(mandatory) : payment cancel amount
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        payCancel,

        /**
         * rewardCancel
         * interface ID : IF-FTM-WL-014
         * reward cancel interface
         * @param rewardTransactionId(mandatory) : reward transaction id
         * @param reqDate(mandatory)  : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        rewardCancel,

        /**
         * userLogin
         * interface ID : IF-FTM_WL-015
         * user login interface
         * @param userId(mandatory) : user id
         * @param userPw(mandatory) : user password
         * @param reqDate(mandatory) : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        userLogin,

        /**
         * userHolding
         * interface ID : IF-FTM_WL-016
         * holding coin interface
         * @param loginAuthKey(mandatory) : login auth key
         * @param coinType(mandatory) : coin type
         * @param reqDate(mandatory) : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        userHolding,

        /**
         * userWalletAddr
         * interface ID : IF-FTM_WL-017
         * user wallet address interface
         * @param loginAuthKey(mandatory) : login auth key
         * @param coinType(mandatory) : coin type
         * @param reqDate(mandatory) : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        userWalletAddr,

        /**
         * coinTransfer
         * interface ID : IF-FTM_WL-018
         * coin transfer interface
         * @param loginAuthKey(mandatory) : login auth key
         * @param coinType(mandatory) : coin type
         * @param receiverAddr(mandatory) : receiver address
         * @param amount(mandatory) : amount
         * @param fee(mandatory) : fee
         * @param procSpeedCd(mandatory) : process speed
         * @param reqDate(mandatory) : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        coinTransfer,

        /**
         * coinConvert
         * interface ID : IF-FTM_WL-019
         * coin convert interface
         * @param loginAuthKey(mandatory) : login auth key
         * @param coinType(mandatory) : coin type
         * @param amount(mandatory) : amount
         * @param fee(mandatory) : fee
         * @param convertCoinType : convert coin type
         * @param procSpeedCd : process speed
         * @param reqDate(mandatory) : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        coinConvert,

        /**
         * userTransferHist
         * interface ID : IF-FTM_WL-020
         * user transfer history interface
         * @param loginAuthKey(mandatory) : login auth key
         * @param pageNum(mandatory) : page number
         * @param pageCnt(mandatory) : page count
         * @param coinType(mandatory) : coin type
         * @param reqDate(mandatory) : current Date ex)yyyy-MM-dd hh:mm:ss
         */
        userTransferHist
    }

    public class InterfaceUrn {
        public static final String fantom_api_0001 = "/wallet/api/1.0/clientAuth";
        public static final String fantom_api_0002 = "/wallet/api/1.0/franchiseList";
        public static final String fantom_api_0003 = "/wallet/api/1.0/franchiseDetail";
        public static final String fantom_api_0004 = "/wallet/api/1.0/franchiseRewardPolicyList";
        public static final String fantom_api_0005 = "/wallet/api/1.0/franchisePenaltyPolicyList";
        public static final String fantom_api_0006 = "/wallet/api/1.0/franchiseRewardList";
        public static final String fantom_api_0007 = "/wallet/api/1.0/franchisePenaltyList";
        public static final String fantom_api_0008 = "/wallet/api/1.0/franchisePayList";
        public static final String fantom_api_0009 = "/wallet/api/1.0/franchisePayFee";
        public static final String fantom_api_0010 = "/wallet/api/1.0/coinMarketPrice";
        public static final String fantom_api_0011 = "/wallet/api/1.0/pay";
        public static final String fantom_api_0012 = "/wallet/api/1.0/reward";
        public static final String fantom_api_0013 = "/wallet/api/1.0/payCancel";
        public static final String fantom_api_0014 = "/wallet/api/1.0/rewardCancel";
        public static final String fantom_api_0015 = "/wallet/api/1.0/login";
        public static final String fantom_api_0016 = "/wallet/api/1.0/userHolding";
        public static final String fantom_api_0017 = "/wallet/api/1.0/userWalletAddr";
        public static final String fantom_api_0018 = "/wallet/api/1.0/coinTransfer";
        public static final String fantom_api_0019 = "/wallet/api/1.0/coinConvert";
        public static final String fantom_api_0020 = "/wallet/api/1.0/userTransferHist";
    }

    public static void logPrint(String tag, String message, boolean debugMode){
        if(BuildConfig.DEBUG && debugMode) {
            Log.d(tag, message);
        }
    }
}
