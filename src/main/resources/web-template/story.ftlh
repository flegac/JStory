<#assign x++>
<div class="card story" id='story-${x}'>
  <div class="card-header why">
    <b>Story ${x}</b> <em>${story.why}</em>
  </div>
  <div class="card-body">
    <p class="card-text">
    	<span class="why">In order to <em>${story.why}</em></span><br/>
    	<span class="who">As a <em>${story.who}</em></span><br/>
		<span class="what">I want to <em>${story.what}</em>.</span><br/>
    </p>
    
    <#if story.tests?size != 0 > 
    	<a href="#" class="card-link" onclick="$('#scenario-${x}').toggle(); return false;">Test scenario</a><br/>
    </#if>
	<span class="tested-by">Source code:<a href="#"> ${story.sourceCode}</a></span>
    
  </div>
</div>

	
<#list story.tests as test>
	<#include "test.ftlh" />
</#list>  