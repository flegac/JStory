<div class="scenario">
	<b>${test.title?capitalize}</b>
	<ol>
	<#list test.steps as step>
		<li>${step}</li>
	</#list>
	</ol>
</div>
