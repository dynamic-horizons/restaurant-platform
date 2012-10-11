<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" version="1.0" indent="yes"
		encoding="UTF-8" />

	<xsl:template match="menu">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">

			<fo:layout-master-set>
				<fo:simple-page-master master-name="summarypage"
					page-height="11in" page-width="8.5in" margin-top="0.5in"
					margin-bottom="0.5in" margin-left="0.5in" margin-right="0.5in">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="summarypage">
				<fo:flow flow-name="xsl-region-body">
				
					<fo:table table-layout="fixed" width="100%">
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										<fo:external-graphic src="http://bdeli.dynamichorizons.net/assets/images/brothers-logo-white@2.png" 
											width="190px" height="80px" content-width="109px" content-height="80px" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										50 South Sixth Street<fo:block />
										Skyway Level<fo:block />
										Downtown Minneapolis
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Monday - Friday, 7AM to 2PM<fo:block />
										Phone: 612.347.8007<fo:block />
										Fax: 612.347.9002
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					
					<fo:table table-layout="fixed" width="100%">
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block text-align="center" font-size="18px" font-weight="bold">
										<xsl:value-of select="@name" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<xsl:if test="menu_description">
								<fo:table-row>
									<fo:table-cell>
										<fo:block text-align="center" font-size="14px" font-weight="bold">
											<xsl:value-of select="menu_description" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</xsl:if>
							<xsl:for-each select="menu_groups/menu_group">
								<fo:table-row>
									<fo:table-cell>
										<fo:block text-align="left" font-size="12px" font-weight="bold" ackground-color="#6b3a40">
											<xsl:value-of select="@group_name" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
	
								<xsl:if test="group_description">
									<fo:table-row>
										<fo:table-cell>
											<fo:block text-align="left" font-size="12px">
												<xsl:value-of select="group_description" />
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
	      						</xsl:if>
      							<fo:table-row background-color="#618f75">
									<fo:table-cell>
										<fo:block color="#fff" text-align="center" font-weight="bold"
											padding-top="0.5em" padding-bottom="0.5em">
											Item
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>
										<fo:block color="#fff" text-align="center" font-weight="bold"
											padding-top="0.5em" padding-bottom="0.5em">
											Description
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>
										<fo:block color="#fff" text-align="center" font-weight="bold"
											padding-top="0.5em" padding-bottom="0.5em">
											Size / Price
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>
										<fo:block color="#fff" text-align="center" font-weight="bold"
											padding-top="0.5em" padding-bottom="0.5em">
											Quantity
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<xsl:for-each select="menu_items/menu_item">
									<xsl:if test="count(menu_item_sizes/menu_item_size) = 0">
										<fo:table-row>
											<fo:table-cell border-left-style="solid" border-top-style="solid"
												border-right-style="solid" border-bottom-style="solid">
												<fo:block text-align="center" padding-top="0.5em">
													<xsl:value-of select="menu_item_name" />
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border-left-style="solid" border-top-style="solid"
												border-right-style="solid" border-bottom-style="solid">
												<fo:block text-align="center" padding-top="0.5em">
													<xsl:value-of select="menu_item_description" />
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border-left-style="solid" border-top-style="solid"
												border-right-style="solid" border-bottom-style="solid">
												<fo:block text-align="center" padding-top="0.5em">
													$ <xsl:value-of select="menu_item_price" />
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border-left-style="solid" border-top-style="solid"
												border-right-style="solid" border-bottom-style="solid">
												<fo:block text-align="center" padding-top="0.5em">
												</fo:block>
											</fo:table-cell>
										</fo:table-row>
									</xsl:if>
									<xsl:if test="count(menu_item_sizes/menu_item_size) &gt; 0">
										<xsl:variable name="numberRows" select="count(menu_item_sizes/menu_item_size)" />
										<xsl:for-each select="menu_item_sizes/menu_item_size">
											<fo:table-row>
												<xsl:if test="position() = 1">
													<fo:table-cell border-left-style="solid" border-top-style="solid"
														border-right-style="solid" border-bottom-style="solid"
														number-rows-spanned="{$numberRows}">
														<fo:block text-align="center" padding-top="0.5em">
															<xsl:value-of select="../../menu_item_name" />
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border-left-style="solid" border-top-style="solid"
														border-right-style="solid" border-bottom-style="solid"
														number-rows-spanned="{$numberRows}">
														<fo:block text-align="center" padding-top="0.5em">
															<xsl:value-of select="../../menu_item_description" />
														</fo:block>
													</fo:table-cell>
     												</xsl:if>
												<fo:table-cell border-left-style="solid" border-top-style="solid"
													border-right-style="solid" border-bottom-style="solid">
													<fo:block text-align="center" padding-top="0.5em">
														 <xsl:value-of select="menu_item_size_name" /> - $ <xsl:value-of select="menu_item_size_price" />
													</fo:block>
												</fo:table-cell>
												<fo:table-cell border-left-style="solid" border-top-style="solid"
													border-right-style="solid" border-bottom-style="solid">
													<fo:block text-align="center" padding-top="0.5em">
													</fo:block>
												</fo:table-cell>
											</fo:table-row>
										</xsl:for-each>		
									</xsl:if>
								</xsl:for-each>
      						</xsl:for-each>
      					</fo:table-body>
      				</fo:table>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>