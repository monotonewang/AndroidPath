package com.example.http_common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * A persistent cookie store which implements the Apache HttpClient CookieStore
 * interface. Cookies are stored and will persist on the user's device between
 * application sessions since they are serialized and stored in
 * SharedPreferences. Instances of this class are designed to be used with
 * AsyncHttpClient#setCookieStore, but can also be used with a regular old
 * apache HttpClient/HttpContext if you prefer.
 */
public class PersistentCookieStore implements CookieStore {

    private static final String LOG_TAG = "PersistentCookieStore";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private static final String COOKIE_NAME_PREFIX = "cookie_";

    private Cookies mCookies;
    private final SharedPreferences cookiePrefs;

    /**
     * Construct a persistent cookie store.
     *
     * @param context Context to attach cookie store to
     */
    public PersistentCookieStore(Context context) {
        cookiePrefs = context.getSharedPreferences(COOKIE_PREFS, 0);
        mCookies = new Cookies();

        // Load any previously stored cookies into the store
        Map<String, ?> prefsMap = cookiePrefs.getAll();
        for (Map.Entry<String, ?> entry : prefsMap.entrySet()) {
            if (((String) entry.getKey()) != null
                    && ((String) entry.getKey())
                    .startsWith(COOKIE_NAME_PREFIX)) {
                String[] cookieNames = TextUtils.split(
                        (String) entry.getKey(), ",");
                for (String name : cookieNames) {
                    String encodedCookie = cookiePrefs.getString(
                            name, null);
                    if (encodedCookie != null) {
                        HttpCookie decodedCookie = decodeCookie(encodedCookie);
                        mCookies.add(entry.getKey(), decodedCookie);
                    }
                }

            }
        }
    }

    @Override
    public void add(URI uri, HttpCookie cookie) {
        String name = mCookies.getCookieToken(uri.getHost(), cookie);
        mCookies.add(uri.getHost(), cookie);
        // Save cookie into local store, or remove if expired
        // Save cookie into persistent store
        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
//        prefsWriter.putString(uri.getHost(),
//                TextUtils.join(",", mCookies.get(uri.getHost())));
        prefsWriter.putString(COOKIE_NAME_PREFIX + name,
                encodeCookie(new SerializableHttpCookie(cookie)));
        prefsWriter.commit();
//        Log.i("info", this + "---add---cookie===" + cookie + "---uri===" + uri);
//        Log.i("info", this + "---add---cookies.size===" + mCookies.get(uri).size());
    }

    @Override
    public List<HttpCookie> get(URI uri) {
//        Log.i("info", this + "---get---cookie.size=" + mCookies.get(uri).size() + "---uri===" + uri);
    return mCookies.get(uri.getHost());
}

    @Override
    public boolean removeAll() {
        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
        prefsWriter.clear();
        prefsWriter.commit();
        mCookies.removeAll();
        return true;
    }

    @Override
    public boolean remove(URI uri, HttpCookie cookie) {
        String name = mCookies.getCookieToken(uri.getHost(), cookie);

        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
        if (cookiePrefs.contains(COOKIE_NAME_PREFIX + name)) {
            prefsWriter.remove(COOKIE_NAME_PREFIX + name);
        }
        prefsWriter.putString(uri.getHost(),
                TextUtils.join(",", mCookies.get(uri.getHost())));
        prefsWriter.commit();

        return mCookies.remove(uri.getHost(), cookie);
    }

    @Override
    public List<HttpCookie> getCookies() {

        return mCookies.getAll();
    }

    @Override
    public List<URI> getURIs() {

        return mCookies.getURIs();
    }

    /**
     * Serializes Cookie object into String
     *
     * @param cookie cookie to be encoded, can be null
     * @return cookie encoded as String
     */
    protected String encodeCookie(SerializableHttpCookie cookie) {
        if (cookie == null)
            return null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(os);
            outputStream.writeObject(cookie);
        } catch (IOException e) {
            Log.d(LOG_TAG, "IOException in encodeCookie", e);
            return null;
        }

        return byteArrayToHexString(os.toByteArray());
    }

    /**
     * Returns cookie decoded from cookie string
     *
     * @param cookieString string of cookie as returned from http request
     * @return decoded cookie or null if exception occured
     */
    protected HttpCookie decodeCookie(String cookieString) {
        byte[] bytes = hexStringToByteArray(cookieString);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                bytes);
        HttpCookie cookie = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    byteArrayInputStream);
            cookie = ((SerializableHttpCookie) objectInputStream.readObject())
                    .getCookie();
        } catch (IOException e) {
            Log.d(LOG_TAG, "IOException in decodeCookie", e);
        } catch (ClassNotFoundException e) {
            Log.d(LOG_TAG, "ClassNotFoundException in decodeCookie", e);
        }

        return cookie;
    }

    /**
     * Using some super basic byte array &lt;-&gt; hex conversions so we don't
     * have to rely on any large Base64 libraries. Can be overridden if you
     * like!
     *
     * @param bytes byte array to be converted
     * @return string containing hex values
     */
    protected String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte element : bytes) {
            int v = element & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    /**
     * Converts hex values from strings to byte arra
     *
     * @param hexString string of hex-encoded values
     * @return decoded byte array
     */
    protected byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
                    .digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }
}