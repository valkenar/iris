/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cfa.vo.iris.test;

import cfa.vo.interop.SAMPController;
import cfa.vo.iris.IrisApplication;
import cfa.vo.sedlib.Sed;
import java.io.File;
import java.net.URL;
import org.astrogrid.samp.Message;
import org.astrogrid.samp.client.SampException;

/**
 *
 * @author olaurino
 */
public class App implements IrisApplication {

    @Override
    public File getConfigurationDir() {
        return new File(System.getProperty("user.home") + "/.vao/iris/importer/");
    }

    @Override
    public boolean isSampEnabled() {
        return false;
    }

    @Override
    public void sendSedMessage(Sed sed, String sedId) throws SampException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendSampMessage(Message msg) throws SampException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SAMPController getSAMPController() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public URL getHelpURL() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}