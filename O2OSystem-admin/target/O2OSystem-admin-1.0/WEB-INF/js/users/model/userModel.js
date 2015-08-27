/**
 * Created by HUANGVI2 on 8/26/2015.
 */
Ext.define('Users', {
    extend: 'Ext.data.Model',
    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
            name: 'Id'
        },
        {
            name: 'Phone'
        },
        {name: 'Name'},
        {
            name: 'isVendor'
        }
    ]
});