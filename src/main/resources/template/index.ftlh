<#ftl output_format="HTML" />
<html>
	<head>
		<title>${page.title}</title>
		<link rel="stylesheet" type="text/css" href="bootstrap/bootstrap.min.css" >
		<link rel="stylesheet" type="text/css" href="style/style.css" >
	</head>

	<body data-spy="scroll" data-target="#my-navbar" data-offset="0">

		  <#assign x = 0>
		  <nav id="my-navbar" class="navbar navbar-light bg-light sticky-top float-right flex-column" >
			<#list page.chapters as chapter>
	 			<a class="nav-link" style="margin-left: 0cm" href="#chapter-${chapter?counter}">Chapter ${chapter?counter}</a>
				<#list chapter.sections as section>
					<a class="nav-link" style="margin-left: 1cm" href="#section-${chapter?counter}-${section?counter}">Section ${chapter?counter}.${section?counter}</a>
					<#list section.epics as story>
						<#assign x++ >
			 			<a class="nav-link" style="margin-left: 1.5cm" href="#story-${x}">Story ${x}</a>
					</#list>
					<#list section.stories as story>
						<#assign x++ >
			  			<a class="nav-link" style="margin-left: 1.5cm" href="#story-${x}">Story ${x}</a>
					</#list>
				</#list>
			</#list>
		  </nav>


		<#assign x = 0>
		<h1>${page.title}</h1>
		<#list page.chapters as chapter>
			<div class='chapter' id='chapter-${chapter?counter}'>
				<h2>Chapter ${chapter?index+1} - ${chapter.title?capitalize}</h2>
				<#list chapter.sections as section>
					<div class='section' id="section-${chapter?counter}-${section?counter}">
						<h3>Section ${chapter?index+1}.${section?index+1} - ${section.title?capitalize}</h3>
						<div class='epics'>
							<#list section.epics as story>
								<#include "story.ftlh" />
							</#list>
						</div>
						<#list section.stories as story>
							<#include "story.ftlh" />
						</#list>
					</div>
				</#list>
			</div>
		</#list>

		<h1>Cahier de tests</h1>
		<#list page.tests as test>
			<#include "test.ftlh" />
		</#list>

	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="bootstrap/bootstrap.min.js"></script>
	
	</body>
</html>
