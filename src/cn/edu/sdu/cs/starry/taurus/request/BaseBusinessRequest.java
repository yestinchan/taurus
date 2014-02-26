package cn.edu.sdu.cs.starry.taurus.request;

import cn.edu.sdu.cs.starry.taurus.common.DefaultBusinessSerializer;
import cn.edu.sdu.cs.starry.taurus.common.exception.BusinessRequestAttributeException;

/**
 * This is a base class for all business requests.
 *
 * @author SDU.xccui
 */
public abstract class BaseBusinessRequest extends DefaultBusinessSerializer {
    protected String requestKey;
    protected Long sessionId;
    protected String userName;
    protected String userIP;
    protected long version = System.currentTimeMillis();
    private Integer requestLoad;

    public BaseBusinessRequest(Long sessionId, String userName, String userIP) {
        this();
        this.sessionId = sessionId;
        this.userName = userName;
        this.userIP = userIP;
    }

    public BaseBusinessRequest() {
        super();
        requestLoad = null;
        requestKey = null;
    }

    /**
     * Return session id for the request
     *
     * @return <code>null</code> if sessionId is not set yet
     */
    public final Long getSessionId() {
        return sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserIP() {
        return userIP;
    }

    public final long getVersion() {
        return version;
    }

    /**
     * Do base self content check and correct attribute if possible.<br/>
     * This method can be used in front.
     *
     * @throws BusinessRequestAttributeException
     */
    public void doBaseAttributeCheck() throws BusinessRequestAttributeException {
        // TODO do base check
    }

    /**
     * Do self attribute check and correct attribute if possible.<br/>
     * Just invoke {@link #doBaseAttributeCheck()} and
     * {@link #doSelfAttributeCheck()}.
     *
     * @throws BusinessRequestAttributeException if encountered an uncorrectable attribute
     */
    public final void doAttributeCheck()
            throws BusinessRequestAttributeException {
        doBaseAttributeCheck();
        doSelfAttributeCheck();
    }

    /**
     * Calculate a load metric for this request. Note that this load metric will
     * <b>not</b> be changed once it's been calculated.
     *
     * @return <ul>
     * <li>a positive integer if the load can be calculated</li>
     * <li>a nonpositive integer if the load can be ignored</li>
     * <ul>
     */
    public final int getRequestLoad() {
        if (requestLoad == null) {
            requestLoad = calRequestLoad();
        }
        return requestLoad < 0 ? 0 : requestLoad;
    }

    /**
     * Calculate a load metric for this request.
     *
     * @return <ul>
     * <li>a positive integer if the load can be calculated</li>
     * <li>a nonpositive integer if the load can be ignored</li>
     * <ul>
     */
    protected abstract int calRequestLoad();

    /**
     * To return an unique key based on parameters contained.<br/>
     * Note that this method may sort some parameter arrays.
     *
     * @return
     */
    protected abstract String genUniqueRequestKey();

    /**
     * Do self attribute check and correct attribute if possible.
     *
     * @throws BusinessRequestAttributeException if encountered an uncorrectable attribute
     */
    protected abstract void doSelfAttributeCheck()
            throws BusinessRequestAttributeException;

}
