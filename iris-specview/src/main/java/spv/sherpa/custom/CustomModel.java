/**
 * Copyright (C) 2012 Smithsonian Astrophysical Observatory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spv.sherpa.custom;

import java.beans.PropertyChangeListener;
import java.net.URL;

/**
 *
 * @author olaurino
 */
public interface CustomModel {
    URL getUrl();
    void setUrl(URL url);
    String getName();
    void setName(String name);
    String getParnames();
    void setParnames(String parnames);
    String getParvals();
    void setParvals(String parvals);
    String getParmins();
    void setParmins(String parmins);
    String getParmaxs();
    void setParmaxs(String parmaxs);
    String getParfrozen();
    void setParfrozen(String parfozen);
    String getFunctionName();
    void setFunctionName(String functionName);
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
}
