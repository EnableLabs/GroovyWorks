<#include "/${parameters.templateDir}/${parameters.theme}/controlheader.ftl" />
<input type="text" name="${parameters.displayFieldName}" value="${parameters.displayNameValue}" disabled="true" id="${parameters.displayFieldId}" size="30" />
<#if (parameters.disabled?default(false) == false) >
<a href="#" onClick="openPartyFinder('${parameters.valueFieldId}','${parameters.displayFieldId}','${parameters.partyNameFieldId}');">Find</a>
</#if>
<input type="hidden" name="${parameters.partyNameFieldName}" value="${parameters.displayNameValue?default("")}" id="${parameters.partyNameFieldId}"  />
<input type="hidden" name="${parameters.valueFieldName}" value="${parameters.idValue?default("")}" id="${parameters.valueFieldId}"  />
<#--
<br />
parameters.partyNameFieldName = ${parameters.partyNameFieldName?default("undefined")}<br />
parameters.partyNameFieldId = ${parameters.partyNameFieldId?default("undefined")}<br />
parameters.displayFieldname = ${parameters.displayFieldName?default("undefined")}<br />
parameters.valueFieldId = ${parameters.valueFieldId?default("undefined")}<br />
parameters.displayFieldId = ${parameters.displayFieldId?default("undefined")}<br />
parameters.valueFieldName = ${parameters.valueFieldName?default("undefined")}<br />
parameters.valueFieldId = ${parameters.valueFieldId?default("undefined")}<br />
<br />
parameters.displayNameValue = ${parameters.displayNameValue?default("undefined")}<br />
parameters.idValue = ${parameters.idValue?default("undefined")}<br />
-->
<#include "/${parameters.templateDir}/${parameters.theme}/controlfooter.ftl" />
