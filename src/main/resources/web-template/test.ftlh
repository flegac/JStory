			<div class="card scenario" id="scenario-${x}">
			  <div class="card-header">
			    <b>${test.title?capitalize}</b>
			  </div>
			  <div class="card-body">

				<table class="table">
				  <thead>
				    <tr>
				      <th>#</th>
				      <th>Given</th>
				      <th>When</th>
				      <th>Then</th>
				    </tr>
				  </thead>
				  <tbody>
					<#list test.steps as step>
				    <tr>
				      <th scope="row">${step?counter}</th>
				      <td>${step.given}</td>
				      <td>${step.when}</td>
				      <td>${step.then}</td>
				    </tr>
				    </#list>
				  </tbody>
				</table>	

			  </div>
			</div>
			
