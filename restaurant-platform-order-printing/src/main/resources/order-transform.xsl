<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- * Copyright (C) 2012 Dynamic Horizons, LLC <https://www.dynamichorizons.net> 
	* * This program is free software: you can redistribute it and/or modify 
	* it under the terms of the GNU Affero General Public License as published 
	by * the Free Software Foundation, either version 3 of the License, or * 
	(at your option) any later version. * * This program is distributed in the 
	hope that it will be useful, * but WITHOUT ANY WARRANTY; without even the 
	implied warranty of * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
	See the * GNU Affero General Public License for more details. * * You should 
	have received a copy of the GNU Affero General Public License * along with 
	this program. If not, see <http://www.gnu.org/licenses/>. -->

<xsl:stylesheet version="1.0"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" version="1.0" indent="yes"
		encoding="UTF-8" />

	<xsl:template match="Order">
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
								<fo:table-cell number-rows-spanned="2">
									<fo:block margin-left="1.25em">
										<fo:external-graphic
											src="http://www.thebrothersdeli.com/assets/images/brothers-logo-white@2.png"
											width="190px" height="80px" content-width="109px"
											content-height="80px" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										50 South Sixth Street
										<fo:block />
										Skyway Level
										<fo:block />
										Downtown Minneapolis
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Monday - Friday, 7AM to 2PM
										<fo:block />
										Phone:&#009;612.341.8007
										<fo:block />
										Fax:&#009;612.341.9002
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell number-columns-spanned="2">
									<fo:block margin-top="0.5em" text-align="left"
										font-size="16px" font-weight="bold">
										Online Ordering - Order: 
										<xsl:value-of select="id" />
									</fo:block>
									<fo:block margin-top="0.25em" margin-left="1em" text-align="left"
										font-size="14px" font-weight="bold">
										Date: <xsl:value-of select="orderDateAsString"/>
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>

					<fo:table table-layout="fixed" width="100%" margin-top="0.5em">
						<fo:table-column column-width="34%" />
						<fo:table-column column-width="33%" />
						<fo:table-column column-width="33%" />

						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block text-align="left" font-size="12px"
										font-weight="bold">
										Customer
									</fo:block>
									<fo:block text-align="left" font-size="12px">
										<xsl:value-of select="customer/user/firstName" />
										&#160;
										<xsl:value-of select="customer/user/lastName" />
										<fo:block />
										<xsl:value-of select="customer/user/emailAddress" />
										<fo:block />
										<xsl:value-of select="customerPhoneNumber/phoneNumber" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block text-align="left" font-size="12px"
										font-weight="bold">
										Billing Address
									</fo:block>
									<fo:block text-align="left" font-size="12px">
										<xsl:value-of select="billingAddress/address1" />
										<fo:block />
										<xsl:value-of select="billingAddress/address2" />
										<fo:block />
										<xsl:value-of select="billingAddress/city" />
										&#160;
										<xsl:value-of select="billingAddress/state" />
										,&#160;
										<xsl:value-of select="billingAddress/zipCode" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block text-align="left" font-size="12px"
										font-weight="bold">
										Delivery Address
									</fo:block>
									<fo:block text-align="left" font-size="12px">
										<xsl:value-of select="deliveryAddress/address1" />
										<fo:block />
										<xsl:value-of select="deliveryAddress/address2" />
										<fo:block />
										<xsl:value-of select="deliveryAddress/city" />
										&#160;
										<xsl:value-of select="deliveryAddress/state" />
										,&#160;
										<xsl:value-of select="deliveryAddress/zipCode" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>

					<fo:table table-layout="fixed" width="100%" margin-top="0.5em">
						<fo:table-column column-width="30%" />
						<fo:table-column column-width="30%" />
						<fo:table-column column-width="15%" />
						<fo:table-column column-width="10%" />
						<fo:table-column column-width="15%" />
						<fo:table-header>
							<fo:table-row background-color="#618f75"
								border-color="#618f75" border-left-style="solid"
								border-top-style="solid" border-right-style="solid"
								border-bottom-style="solid">
								<fo:table-cell>
									<fo:block color="#fff" text-align="center"
										font-weight="bold" padding-top="0.5em" padding-bottom="0.5em">
										Item
										Name
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block color="#fff" text-align="center"
										font-weight="bold" padding-top="0.5em" padding-bottom="0.5em">
										Options
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block color="#fff" text-align="center"
										font-weight="bold" padding-top="0.5em" padding-bottom="0.5em">
										Item
										Price
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block color="#fff" text-align="center"
										font-weight="bold" padding-top="0.5em" padding-bottom="0.5em">
										Quantity
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block color="#fff" text-align="center"
										font-weight="bold" padding-top="0.5em" padding-bottom="0.5em">
										Item
										Total
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-header>
						<fo:table-footer>
							<fo:table-row>
								<fo:table-cell>
									<fo:block text-align="center" padding-top="0.5em">
										Order Status:
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block text-align="center" padding-top="0.5em">
										<xsl:value-of select="orderStatus" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="2" border-left-style="solid"
									border-top-style="solid" border-right-style="solid"
									border-bottom-style="solid">
									<fo:block text-align="center" padding-top="0.5em">
										Estimated Subtotal:
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-left-style="solid"
									border-top-style="solid" border-right-style="solid"
									border-bottom-style="solid">
									<fo:block text-align="end" padding-top="0.5em"
										margin-right="0.5em">
										<xsl:value-of select="format-number(orderSubTotal, '#,##0.00;(#,##0.00)')" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block text-align="center" padding-top="0.5em">
										Order Type:
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block text-align="center" padding-top="0.5em">
										<xsl:value-of select="orderType" />
									</fo:block>
								</fo:table-cell>
								<xsl:if test="deliveryCharge">
									<fo:table-cell number-columns-spanned="2" border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="center" padding-top="0.5em">
											Delivery Charge:
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="end" padding-top="0.5em"
											margin-right="0.5em">
											<xsl:value-of select="format-number(deliveryCharge, '#,##0.00;(#,##0.00)')" />
										</fo:block>
									</fo:table-cell>
								</xsl:if>
								<xsl:if test="not(deliveryCharge)">
									<fo:table-cell number-columns-spanned="2" border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="center" padding-top="0.5em">
											Sales Tax:
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="end" padding-top="0.5em"
											margin-right="0.5em">
											<xsl:value-of select="format-number(salesTax, '#,##0.00;(#,##0.00)')" />
										</fo:block>
									</fo:table-cell>
								</xsl:if>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block text-align="center" padding-top="0.5em">
										Asap Order:
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block text-align="center" padding-top="0.5em">
										<xsl:value-of select="isAsapOrder" />
									</fo:block>
								</fo:table-cell>
								<xsl:if test="deliveryCharge">
									<fo:table-cell number-columns-spanned="2" border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="center" padding-top="0.5em">
											Sales Tax:
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="end" padding-top="0.5em"
											margin-right="0.5em">
											<xsl:value-of select="format-number(salesTax, '#,##0.00;(#,##0.00)')" />
										</fo:block>
									</fo:table-cell>
								</xsl:if>
								<xsl:if test="not(deliveryCharge)">
									<fo:table-cell number-columns-spanned="2" border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="center" padding-top="0.5em">
											Order Total:
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="end" padding-top="0.5em"
											margin-right="0.5em">
											<xsl:value-of select="format-number(orderTotal, '#,##0.00;(#,##0.00)')" />
										</fo:block>
									</fo:table-cell>
								</xsl:if>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell number-columns-spanned="2">
									<fo:block text-align="center" padding-top="0.5em">
									</fo:block>
								</fo:table-cell>
								<xsl:if test="deliveryCharge">
									<fo:table-cell number-columns-spanned="2" border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="center" padding-top="0.5em">
											Order Total:
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="end" padding-top="0.5em"
											margin-right="0.5em">
											<xsl:value-of select="format-number(orderTotal, '#,##0.00;(#,##0.00)')" />
										</fo:block>
									</fo:table-cell>
								</xsl:if>
							</fo:table-row>
						</fo:table-footer>
						<fo:table-body>
							<xsl:for-each select="orderMenuSelections/orderMenuSelections">
								<fo:table-row>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="center" padding-top="0.5em">
											<xsl:value-of select="selectedMenuItem/menuItemName" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="center" padding-top="0.5em">
											<xsl:value-of select="selectedMenuItemSize/menuItemSizeName" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="end" padding-top="0.5em"
											margin-right="0.5em">
											<xsl:value-of select="format-number(price, '#,##0.00;(#,##0.00)')" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="center" padding-top="0.5em">
											<xsl:value-of select="quantity" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-left-style="solid"
										border-top-style="solid" border-right-style="solid"
										border-bottom-style="solid">
										<fo:block text-align="end" padding-top="0.5em"
											margin-right="0.5em">
											<xsl:value-of select="format-number(total, '#,##0.00;(#,##0.00)')" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</xsl:for-each>
						</fo:table-body>
					</fo:table>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>