/*
 * Copyright (c) 2012, 2022 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2012, 2022 IBM Corporation. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     02/08/2012-2.4 Guy Pelletier
//       - 350487: JPA 2.1 Specification defined support for Stored Procedure Calls
//     06/20/2014-2.5.2 Rick Curtis
//       - 437760: AttributeOverride with no column name defined doesn't work.
package org.eclipse.persistence.testing.models.jpa21.advanced;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Embeddable
public class EmploymentPeriod implements Serializable, Cloneable {
    @Column(name="NON_DEFAULT_START_DATE")
    private Date startDate;
    private Date endDate;

    @OneToMany
    private Collection<LargeProject> largeProjectsWorkedOn;

    @OneToMany
    private Collection<SmallProject> smallProjectsWorkedOn;

    public EmploymentPeriod() {
        largeProjectsWorkedOn = new ArrayList<>();
        smallProjectsWorkedOn = new ArrayList<>();
    }

    public EmploymentPeriod(Date theStartDate, Date theEndDate) {
        startDate = theStartDate;
        endDate = theEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmploymentPeriod that = (EmploymentPeriod) o;

        if (!Objects.equals(startDate, that.startDate)) return false;
        if (!Objects.equals(endDate, that.endDate)) return false;
        if (!Objects.equals(largeProjectsWorkedOn, that.largeProjectsWorkedOn))
            return false;
        if (!Objects.equals(smallProjectsWorkedOn, that.smallProjectsWorkedOn))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (largeProjectsWorkedOn != null ? largeProjectsWorkedOn.hashCode() : 0);
        result = 31 * result + (smallProjectsWorkedOn != null ? smallProjectsWorkedOn.hashCode() : 0);
        return result;
    }

    @Column(name="E_DATE")
    public Date getEndDate() {
        return endDate;
    }

    @Column(name="S_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public Collection<LargeProject> getLargeProjectsWorkedOn() {
        return largeProjectsWorkedOn;
    }

    public void setLargeProjectsWorkedOn(Collection<LargeProject> largeProjectsWorkedOn) {
        this.largeProjectsWorkedOn = largeProjectsWorkedOn;
    }

    public Collection<SmallProject> getSmallProjectsWorkedOn() {
        return smallProjectsWorkedOn;
    }

    public void setSmallProjectsWorkedOn(Collection<SmallProject> smallProjectsWorkedOn) {
        this.smallProjectsWorkedOn = smallProjectsWorkedOn;
    }

    public String toString() {
        java.io.StringWriter writer = new java.io.StringWriter();
        writer.write("EmploymentPeriod: ");

        if (getStartDate() != null) {
            writer.write(this.getStartDate().toString());
        }

        writer.write("-");

        if (getEndDate() != null) {
            writer.write(this.getEndDate().toString());
        }

        writer.write("-");

        if (getSmallProjectsWorkedOn() != null) {
            writer.write('{');
            for (Project project : getSmallProjectsWorkedOn()) {
                writer.write(project.toString());
                writer.write(',');
            }
            writer.write('}');
        }

        writer.write("-");

        if (getLargeProjectsWorkedOn() != null) {
            writer.write('{');
            for (Project project : getLargeProjectsWorkedOn()) {
                writer.write(project.toString());
                writer.write(',');
            }
            writer.write('}');
        }

        return writer.toString();
    }
}
