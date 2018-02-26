package william.servian.channelmessaging;

/**
 * Created by servianw on 19/01/2018.
 */
public interface OnDownloadListener {
    public void onDownloadComplete(String downloadContent);
    public void onDownloadError(String error);
}
