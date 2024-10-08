/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.filter.v1_1;

import javax.xml.namespace.QName;
import org.geotools.api.filter.FilterFactory;
import org.geotools.api.filter.expression.PropertyName;
import org.geotools.api.filter.sort.SortBy;
import org.geotools.api.filter.sort.SortOrder;
import org.geotools.xsd.AbstractComplexBinding;
import org.geotools.xsd.ElementInstance;
import org.geotools.xsd.Node;

/**
 * Binding object for the type http://www.opengis.net/ogc:SortPropertyType.
 *
 * <p>
 *
 * <pre>
 *         <code>
 *  &lt;xsd:complexType name="SortPropertyType"&gt;
 *      &lt;xsd:sequence&gt;
 *          &lt;xsd:element ref="ogc:PropertyName"/&gt;
 *          &lt;xsd:element minOccurs="0" name="SortOrder" type="ogc:SortOrderType"/&gt;
 *      &lt;/xsd:sequence&gt;
 *  &lt;/xsd:complexType&gt;
 *
 *          </code>
 *         </pre>
 *
 * @generated
 */
public class SortPropertyTypeBinding extends AbstractComplexBinding {
    FilterFactory filterfactory;

    public SortPropertyTypeBinding(FilterFactory filterfactory) {
        this.filterfactory = filterfactory;
    }

    /** @generated */
    @Override
    public QName getTarget() {
        return OGC.SortPropertyType;
    }

    /**
     *
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated modifiable
     */
    @Override
    public Class getType() {
        return SortBy.class;
    }

    /**
     *
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated modifiable
     */
    @Override
    public Object parse(ElementInstance instance, Node node, Object value) throws Exception {
        PropertyName name = node.getChildValue(PropertyName.class);
        SortOrder order = node.getChildValue(SortOrder.class);

        if (order == null) {
            order = SortOrder.ASCENDING;
        }

        return filterfactory.sort(name.getPropertyName(), order);
    }

    @Override
    public Object getProperty(Object object, QName name) throws Exception {
        SortBy sortBy = (SortBy) object;

        if (OGC.PropertyName.equals(name)) {
            return sortBy.getPropertyName();
        }

        if ("SortOrder".equals(name.getLocalPart())) {
            return sortBy.getSortOrder();
        }

        return null;
    }
}
