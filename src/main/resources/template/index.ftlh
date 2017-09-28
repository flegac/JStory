<#ftl output_format="HTML" />
<html>
	<head>
		<title>${page.title}</title>
		<link rel="stylesheet" type="text/css" href="bootstrap/bootstrap.min.css" >
		<link rel="stylesheet" type="text/css" href="style/style.css" >
	</head>

	<body data-spy="scroll" data-target="#table-of-contents" >

		<#include "tableOfContents.ftlh" />

		<div class="container">
			<h1 data-offset="0">${page.title}</h1>
			
			<#assign x = 0>
			<#list page.chapters as chapter>
				<div class='chapter' id='chapter-${chapter?counter}'>
					<h2>${chapter?index+1}. ${chapter.title?capitalize}</h2>
					<#list chapter.sections as section>
					
						<div class='section' id="section-${chapter?counter}-${section?counter}">
							<h3>${chapter?index+1}.${section?index+1}. ${section.title?capitalize}</h3>
							<#list section.subSections as subSection>
		
								<div class='subsection' id="subsection-${chapter?counter}-${section?counter}-${subSection?counter}">
									<h4>${chapter?index+1}.${section?index+1}.${subSection?index+1}. ${subSection.title?capitalize}</h4>
									<div class='epics'>
										<#list subSection.epics as story>
											<#include "story.ftlh" />
										</#list>
									</div>
									<#list subSection.stories as story>
										<#include "story.ftlh" />
									</#list>
									<#list subSection.tests as test>
										<#include "test.ftlh" />
									</#list>								
								</div>
							</#list>
						</div>
						
					</#list>
				</div>
		
			</#list>
		</div>

<pre>
















































</pre>

	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="bootstrap/bootstrap.min.js"></script>
	
	</body>
</html>
