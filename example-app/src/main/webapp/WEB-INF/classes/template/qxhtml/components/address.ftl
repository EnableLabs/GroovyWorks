<#assign address = parameters.nameValue />
<#if address?exists >
<#if address.firstName?exists >
${address.firstName}
</#if>
<#if address.lastName?exists >
${address.lastName}"
</#if>
<br />
<#if address.address1?exists >
${addrss.address1}<br />
</#if>
<#if address.address2?exists >
${address.address2}<br />
</#if>
<#if address.city?exists >
${address.city},  
</#if>
<#if address.state?exists >
${address.state} 
</#if>
<#if address.postalCode?exists >
${address.postalCode}
</#if>
<br />
<#if address.country?exists >
${address.country}<br />
</#if>
<#if address.telephone?exists >
Phone: ${address.telephone}<br />
</#if>
<#if address.fax?exists >
Fax: ${address.fax}<br />
</#if>
<#if (address.emailAddress?exists)>
    <a href="mailto:${address.emailAddress}">${address.emailAddress}</a>
</#if>
</#if>
