/**
 * Copyright (C) 2015 Smithsonian Astrophysical Observatory
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
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfa.vo.sed.science.stacker;

import java.util.List;

/**
 *
 * @author jbudynk
 */
public interface SedStackerRedshiftPayload {
    
    public List<SegmentPayload> getSegments();

    public void addSegment(SegmentPayload payload);
    
    /** get SEDs that were excluded from redshifting
     * 
     * @return list of Strings of SED ID's that were excluded from shifting 
     */
    public List<String> getExcludeds();
    
    public void addExcluded(String excludedIds);

    public Double getZ0();

    public void setZ0(Double redshift);
    
    public Boolean getCorrectFlux();

    public void setCorrectFlux(Boolean correctFlux);
}
