<#assign x++>
<div class="card story" id='item-${x}'>
  <div class="card-header why">
    In order to <em>${story.why}</em>
  </div>
  <div class="card-body">
    <p class="card-text">
    	<span class="who">As a <em>${story.who}</em></span><br/>
		<span class="what">I want to <em>${story.what}</em></span>.<br/>
    </p>
    <a href="#" class="card-link">Card link</a>
    <a href="#" class="card-link">Another link</a>
  </div>
</div>

<#list story.tests as test>
	<#include "test.ftlh" />
</#list>	
