/*
 * The MIT License
 *
 * Copyright (c) 2018 Slug Games
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sluggames.WarMaker.views.License;

import com.sluggames.WarMaker.audio.sound.SoundEffect;
import com.sluggames.WarMaker.views.MainMenu.MainMenuModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * @author david.boeger@sluggames.com
 */
public class LicenseController {
	/*
		******************
		*** COMPONENTS ***
		******************
	*/
	/*
			-----------------
			| LICENSE TEXTS |
			-----------------
	*/
	/*
				\\\\\\\\
				\ GAME \
				\\\\\\\\
	*/
	@FXML
	private Text gameLicenseText;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	public static final String GAME_LICENSE =
	    "The MIT License" +
	    "\n\n" +
	    "Copyright (c) 2018 Slug Games" +
	    "\n\n" +
	    "Permission is hereby granted, free of charge, to any person " +
	    "obtaining a copy of this software and associated documentation " +
	    "files (the \"Software\"), to deal in the Software without " +
	    "restriction, including without limitation the rights to use, " +
	    "copy, modify, merge, publish, distribute, sublicense, and/or " +
	    "sell copies of the Software, and to permit persons to whom the " +
	    "Software is furnished to do so, subject to the following " +
	    "conditions:" +
	    "\n\n" +
	    "The above copyright notice and this permission notice shall be " +
	    "included in all copies or substantial portions of the Software." +
	    "\n\n" +
	    "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY " +
	    "KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE " +
	    "WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE " +
	    "AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT " +
	    "HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, " +
	    "WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING " +
	    "FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR " +
	    "OTHER DEALINGS IN THE SOFTWARE.";

	private void initializeGameLicenseText() {
		gameLicenseText.setText(GAME_LICENSE);
	}

	/*
				\\\\\\\\\
				\ MUSIC \
				\\\\\\\\\
	*/
	@FXML
	private Text musicLicenseText;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	public static final String MUSIC_LICENSE =
	    "All music by Alexandr Zhelanov." +
	    "\n(https://soundcloud.com/alexandr-zhelanov)" +
	    "\n(https://opengameart.org/users/alexandr-zhelanov)" +
	    "\n\n" +
	    "\"Battle Themes\" music collection:" +
	    "\n\"Battle Theme 2\"" +
	    "\n\"Battle Theme 3\"" +
	    "\n\"Battle Theme 5\"" +
	    "\n(https://opengameart.org/content/battle-themes)" +
	    "\n\n" +
	    "Licensed under Creative Commons Attribution 4.0 International:" +
	    "\n(https://creativecommons.org/licenses/by/4.0/legalcode)" +
	    "\n\n" +
	    "CC-BY 4.0 License Text:" +
	    "\n\n" +
	    "Creative Commons Attribution 4.0 International Public License" +
	    "\n\n" +
	    "By exercising the Licensed Rights (defined below), You accept " +
	    "and agree to be bound by the terms and conditions of this " +
	    "Creative Commons Attribution 4.0 International Public License " +
	    "(\"Public License\"). To the extent this Public License may be " +
	    "interpreted as a contract, You are granted the Licensed Rights " +
	    "in consideration of Your acceptance of these terms and " +
	    "conditions, and the Licensor grants You such rights in " +
	    "consideration of benefits the Licensor receives from making the " +
	    "Licensed Material available under these terms and conditions." +
	    "\n\n" +
	    "Section 1 – Definitions." +
	    "\n\n" +
	    "\ta. Adapted Material means material subject to Copyright and " +
	    "Similar Rights that is derived from or based upon the Licensed " +
	    "Material and in which the Licensed Material is translated, " +
	    "altered, arranged, transformed, or otherwise modified in a " +
	    "manner requiring permission under the Copyright and Similar " +
	    "Rights held by the Licensor. For purposes of this Public " +
	    "License, where the Licensed Material is a musical work, " +
	    "performance, or sound recording, Adapted Material is always " +
	    "produced where the Licensed Material is synched in timed " +
	    "relation with a moving image." +
	    "\n\n" +
	    "\tb. Adapter's License means the license You apply to Your " +
	    "Copyright and Similar Rights in Your contributions to Adapted " +
	    "Material in accordance with the terms and conditions of this " +
	    "Public License." +
	    "\n\n" +
	    "\tc. Copyright and Similar Rights means copyright and/or similar " +
	    "rights closely related to copyright including, without " +
	    "limitation, performance, broadcast, sound recording, and Sui " +
	    "Generis Database Rights, without regard to how the rights are " +
	    "labeled or categorized. For purposes of this Public License, " +
	    "the rights specified in Section 2(b)(1)-(2) are not Copyright " +
	    "and Similar Rights." +
	    "\n\n" +
	    "\td. Effective Technological Measures means those measures " +
	    "that, in the absence of proper authority, may not be " +
	    "circumvented under laws fulfilling obligations under Article 11 " +
	    "of the WIPO Copyright Treaty adopted on December 20, 1996, " +
	    "and/or similar international agreements." +
	    "\n\n" +
	    "\te. Exceptions and Limitations means fair use, fair dealing, " +
	    "and/or any other exception or limitation to Copyright and " +
	    "Similar Rights that applies to Your use of the Licensed " +
	    "Material." +
	    "\n\n" +
	    "\tf. Licensed Material means the artistic or literary work, " +
	    "database, or other material to which the Licensor applied this " +
	    "Public License." +
	    "\n\n" +
	    "\tg. Licensed Rights means the rights granted to You subject to " +
	    "the terms and conditions of this Public License, which are " +
	    "limited to all Copyright and Similar Rights that apply to Your " +
	    "use of the Licensed Material and that the Licensor has " +
	    "authority to license." +
	    "\n\n" +
	    "\th. Licensor means the individual(s) or entity(ies) granting " +
	    "rights under this Public License." +
	    "\n\n" +
	    "\ti. Share means to provide material to the public by any means " +
	    "or process that requires permission under the Licensed Rights, " +
	    "such as reproduction, public display, public performance, " +
	    "distribution, dissemination, communication, or importation, and " +
	    "to make material available to the public including in ways that " +
	    "members of the public may access the material from a place and " +
	    "at a time individually chosen by them." +
	    "\n\n" +
	    "\tj. Sui Generis Database Rights means rights other than " +
	    "copyright resulting from Directive 96/9/EC of the European " +
	    "Parliament and of the Council of 11 March 1996 on the legal " +
	    "protection of databases, as amended and/or succeeded, as well " +
	    "as other essentially equivalent rights anywhere in the world." +
	    "\n\n" +
	    "\tk. You means the individual or entity exercising the Licensed " +
	    "Rights under this Public License. Your has a corresponding " +
	    "meaning." +
	    "\n\n" +
	    "Section 2 – Scope." +
	    "\n\n" +
	    "\ta. License grant." +
	    "\n\n" +
	    "\t\t1. Subject to the terms and conditions of this Public " +
	    "License, the Licensor hereby grants You a worldwide, " +
	    "royalty-free, non-sublicensable, non-exclusive, irrevocable " +
	    "license to exercise the Licensed Rights in the Licensed " +
	    "Material to:" +
	    "\n\n" +
	    "\t\t\tA. reproduce and Share the Licensed Material, in whole or " +
	    "in part; and" +
	    "\n\n" +
	    "\t\t\tB. produce, reproduce, and Share Adapted Material." +
	    "\n\n" +
	    "\t\t2. Exceptions and Limitations. For the avoidance of doubt, " +
	    "where Exceptions and Limitations apply to Your use, this Public " +
	    "License does not apply, and You do not need to comply with its " +
	    "terms and conditions." +
	    "\n\n" +
	    "\t\t3. Term. The term of this Public License is specified in " +
	    "Section 6(a)." +
	    "\n\n" +
	    "\t\t4. Media and formats; technical modifications allowed. The " +
	    "Licensor authorizes You to exercise the Licensed Rights in all " +
	    "media and formats whether now known or hereafter created, and " +
	    "to make technical modifications necessary to do so. The " +
	    "Licensor waives and/or agrees not to assert any right or " +
	    "authority to forbid You from making technical modifications " +
	    "necessary to exercise the Licensed Rights, including technical " +
	    "modifications necessary to circumvent Effective Technological " +
	    "Measures. For purposes of this Public License, simply making " +
	    "modifications authorized by this Section 2(a)(4) never produces " +
	    "Adapted Material." +
	    "\n\n" +
	    "\t\t5. Downstream recipients." +
	    "\n\n" +
	    "\t\t\tA. Offer from the Licensor – Licensed Material. Every " +
	    "recipient of the Licensed Material automatically receives an " +
	    "offer from the Licensor to exercise the Licensed Rights under " +
	    "the terms and conditions of this Public License." +
	    "\n\n" +
	    "\t\t\tB. No downstream restrictions. You may not offer or " +
	    "impose any additional or different terms or conditions on, or " +
	    "apply any Effective Technological Measures to, the Licensed " +
	    "Material if doing so restricts exercise of the Licensed Rights " +
	    "by any recipient of the Licensed Material." +
	    "\n\n" +
	    "\t\t6. No endorsement. Nothing in this Public License " +
	    "constitutes or may be construed as permission to assert or " +
	    "imply that You are, or that Your use of the Licensed Material " +
	    "is, connected with, or sponsored, endorsed, or granted official " +
	    "status by, the Licensor or others designated to receive " +
	    "attribution as provided in Section 3(a)(1)(A)(i)." +
	    "\n\n" +
	    "\tb. Other rights." +
	    "\n\n" +
	    "\t\t1. Moral rights, such as the right of integrity, are not " +
	    "licensed under this Public License, nor are publicity, privacy, " +
	    "and/or other similar personality rights; however, to the extent " +
	    "possible, the Licensor waives and/or agrees not to assert any " +
	    "such rights held by the Licensor to the limited extent " +
	    "necessary to allow You to exercise the Licensed Rights, but not " +
	    "otherwise." +
	    "\n\n" +
	    "\t\t2. Patent and trademark rights are not licensed under this " +
	    "Public License." +
	    "\n\n" +
	    "\t\t3. To the extent possible, the Licensor waives any right to " +
	    "collect royalties from You for the exercise of the Licensed " +
	    "Rights, whether directly or through a collecting society under " +
	    "any voluntary or waivable statutory or compulsory licensing " +
	    "scheme. In all other cases the Licensor expressly reserves any " +
	    "right to collect such royalties." +
	    "\n\n" +
	    "Section 3 – License Conditions." +
	    "\n\n" +
	    "Your exercise of the Licensed Rights is expressly made subject " +
	    "to the following conditions." +
	    "\n\n" +
	    "\ta. Attribution." +
	    "\n\n" +
	    "\t\t1. If You Share the Licensed Material (including in " +
	    "modified form), You must:" +
	    "\n\n" +
	    "\t\t\tA. retain the following if it is supplied by the Licensor " +
	    "with the Licensed Material:" +
	    "\n\n" +
	    "\t\t\t\ti. identification of the creator(s) of the Licensed " +
	    "Material and any others designated to receive attribution, in " +
	    "any reasonable manner requested by the Licensor (including by " +
	    "pseudonym if designated);" +
	    "\n\n" +
	    "\t\t\t\tii. a copyright notice;" +
	    "\n\n" +
	    "\t\t\t\tiii. a notice that refers to this Public License;" +
	    "\n\n" +
	    "\t\t\t\tiv. a notice that refers to the disclaimer of " +
	    "warranties;" +
	    "\n\n" +
	    "\t\t\t\tv. a URI or hyperlink to the Licensed Material to the " +
	    "extent reasonably practicable;" +
	    "\n\n" +
	    "\t\t\tB. indicate if You modified the Licensed Material and " +
	    "retain an indication of any previous modifications; and" +
	    "\n\n" +
	    "\t\t\tC. indicate the Licensed Material is licensed under this " +
	    "Public License, and include the text of, or the URI or " +
	    "hyperlink to, this Public License." +
	    "\n\n" +
	    "\t\t2. You may satisfy the conditions in Section 3(a)(1) in any " +
	    "reasonable manner based on the medium, means, and context in " +
	    "which You Share the Licensed Material. For example, it may be " +
	    "reasonable to satisfy the conditions by providing a URI or " +
	    "hyperlink to a resource that includes the required information." +
	    "\n\n" +
	    "\t\t3. If requested by the Licensor, You must remove any of the " +
	    "information required by Section 3(a)(1)(A) to the extent " +
	    "reasonably practicable." +
	    "\n\n" +
	    "\t\t4. If You Share Adapted Material You produce, the Adapter's " +
	    "License You apply must not prevent recipients of the Adapted " +
	    "Material from complying with this Public License." +
	    "\n\n" +
	    "Section 4 – Sui Generis Database Rights." +
	    "\n\n" +
	    "Where the Licensed Rights include Sui Generis Database Rights " +
	    "that apply to Your use of the Licensed Material:" +
	    "\n\n" +
	    "\ta. for the avoidance of doubt, Section 2(a)(1) grants You the " +
	    "right to extract, reuse, reproduce, and Share all or a " +
	    "substantial portion of the contents of the database;" +
	    "\n\n" +
	    "\tb. if You include all or a substantial portion of the " +
	    "database contents in a database in which You have Sui Generis " +
	    "Database Rights, then the database in which You have Sui " +
	    "Generis Database Rights (but not its individual contents) is " +
	    "Adapted Material; and" +
	    "\n\n" +
	    "\tc. You must comply with the conditions in Section 3(a) if You " +
	    "Share all or a substantial portion of the contents of the " +
	    "database." +
	    "\n\n" +
	    "For the avoidance of doubt, this Section 4 supplements and does " +
	    "not replace Your obligations under this Public License where " +
	    "the Licensed Rights include other Copyright and Similar Rights." +
	    "\n\n" +
	    "Section 5 – Disclaimer of Warranties and Limitation of " +
	    "Liability." +
	    "\n\n" +
	    "\ta. Unless otherwise separately undertaken by the Licensor, to " +
	    "the extent possible, the Licensor offers the Licensed Material " +
	    "as-is and as-available, and makes no representations or " +
	    "warranties of any kind concerning the Licensed Material, " +
	    "whether express, implied, statutory, or other. This includes, " +
	    "without limitation, warranties of title, merchantability, " +
	    "fitness for a particular purpose, non-infringement, absence of " +
	    "latent or other defects, accuracy, or the presence or absence " +
	    "of errors, whether or not known or discoverable. Where " +
	    "disclaimers of warranties are not allowed in full or in part, " +
	    "this disclaimer may not apply to You." +
	    "\n\n" +
	    "\tb. To the extent possible, in no event will the Licensor be " +
	    "liable to You on any legal theory (including, without " +
	    "limitation, negligence) or otherwise for any direct, special, " +
	    "indirect, incidental, consequential, punitive, exemplary, or " +
	    "other losses, costs, expenses, or damages arising out of this " +
	    "Public License or use of the Licensed Material, even if the " +
	    "Licensor has been advised of the possibility of such losses, " +
	    "costs, expenses, or damages. Where a limitation of liability is " +
	    "not allowed in full or in part, this limitation may not apply " +
	    "to You." +
	    "\n\n" +
	    "\tc. The disclaimer of warranties and limitation of liability " +
	    "provided above shall be interpreted in a manner that, to the " +
	    "extent possible, most closely approximates an absolute " +
	    "disclaimer and waiver of all liability." +
	    "\n\n" +
	    "Section 6 – Term and Termination." +
	    "\n\n" +
	    "\ta. This Public License applies for the term of the Copyright " +
	    "and Similar Rights licensed here. However, if You fail to " +
	    "comply with this Public License, then Your rights under this " +
	    "Public License terminate automatically." +
	    "\n\n" +
	    "\tb. Where Your right to use the Licensed Material has " +
	    "terminated under Section 6(a), it reinstates:" +
	    "\n\n" +
	    "\t\t1. automatically as of the date the violation is cured, " +
	    "provided it is cured within 30 days of Your discovery of the " +
	    "violation; or" +
	    "\n\n" +
	    "\t\t2. upon express reinstatement by the Licensor." +
	    "\n\n" +
	    "For the avoidance of doubt, this Section 6(b) does not affect " +
	    "any right the Licensor may have to seek remedies for Your " +
	    "violations of this Public License." +
	    "\n\n" +
	    "\tc. For the avoidance of doubt, the Licensor may also offer " +
	    "the Licensed Material under separate terms or conditions or " +
	    "stop distributing the Licensed Material at any time; however, " +
	    "doing so will not terminate this Public License." +
	    "\n\n" +
	    "\td. Sections 1, 5, 6, 7, and 8 survive termination of this " +
	    "Public License." +
	    "\n\n" +
	    "Section 7 – Other Terms and Conditions." +
	    "\n\n" +
	    "\ta. The Licensor shall not be bound by any additional or " +
	    "different terms or conditions communicated by You unless " +
	    "expressly agreed." +
	    "\n\n" +
	    "\tb. Any arrangements, understandings, or agreements regarding " +
	    "the Licensed Material not stated herein are separate from and " +
	    "independent of the terms and conditions of this Public License." +
	    "\n\n" +
	    "Section 8 – Interpretation." +
	    "\n\n" +
	    "\ta. For the avoidance of doubt, this Public License does not, " +
	    "and shall not be interpreted to, reduce, limit, restrict, or " +
	    "impose conditions on any use of the Licensed Material that " +
	    "could lawfully be made without permission under this Public " +
	    "License." +
	    "\n\n" +
	    "\tb. To the extent possible, if any provision of this Public " +
	    "License is deemed unenforceable, it shall be automatically " +
	    "reformed to the minimum extent necessary to make it " +
	    "enforceable. If the provision cannot be reformed, it shall be " +
	    "severed from this Public License without affecting the " +
	    "enforceability of the remaining terms and conditions." +
	    "\n\n" +
	    "\tc. No term or condition of this Public License will be waived " +
	    "and no failure to comply consented to unless expressly agreed " +
	    "to by the Licensor." +
	    "\n\n" +
	    "\td. Nothing in this Public License constitutes or may be " +
	    "interpreted as a limitation upon, or waiver of, any privileges " +
	    "and immunities that apply to the Licensor or You, including " +
	    "from the legal processes of any jurisdiction or authority.";

	private void initializeMusicLicenseText() {
		musicLicenseText.setText(MUSIC_LICENSE);
	}

	/*
				\\\\\\\\\\\\\\\\\
				\ SOUND EFFECTS \
				\\\\\\\\\\\\\\\\\
	*/
	@FXML
	private Text soundEffectsLicenseText;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	public static final String SOUND_EFFECTS_LICENSE =
	    "Weapon load sound effect by Michel Baradari." +
	    "\n(http://apollo-music.de/)" +
	    "\n\n" +
	    "\"2 Metal Weapon Clicks\" sound effects collection:" +
	    "\n\"Weapon Load\"" +
	    "\n\n" +
	    "Licensed under Creative Commons Attribution 3.0 Unported:" +
	    "\n(https://creativecommons.org/licenses/by/3.0/legalcode)" +
	    "\n\n\n" +
	    "CC-BY 3.0 License Text:" +
	    "\n\n" +
	    "License" +
	    "\n\n" +
	    "THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS " +
	    "CREATIVE COMMONS PUBLIC LICENSE (\"CCPL\" OR \"LICENSE\"). THE " +
	    "WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW. ANY " +
	    "USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENSE OR " +
	    "COPYRIGHT LAW IS PROHIBITED." +
	    "\n\n" +
	    "BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT " +
	    "AND AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE " +
	    "EXTENT THIS LICENSE MAY BE CONSIDERED TO BE A CONTRACT, THE " +
	    "LICENSOR GRANTS YOU THE RIGHTS CONTAINED HERE IN CONSIDERATION " +
	    "OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS." +
	    "\n\n" +
	    "1. Definitions" +
	    "\n\n" +
	    "\ta. \"Adaptation\" means a work based upon the Work, or upon " +
	    "the Work and other pre-existing works, such as a translation, " +
	    "adaptation, derivative work, arrangement of music or other " +
	    "alterations of a literary or artistic work, or phonogram or " +
	    "performance and includes cinematographic adaptations or any " +
	    "other form in which the Work may be recast, transformed, or " +
	    "adapted including in any form recognizably derived from the " +
	    "original, except that a work that constitutes a Collection will " +
	    "not be considered an Adaptation for the purpose of this " +
	    "License. For the avoidance of doubt, where the Work is a " +
	    "musical work, performance or phonogram, the synchronization of " +
	    "the Work in timed-relation with a moving image (\"synching\") " +
	    "will be considered an Adaptation for the purpose of this " +
	    "License." +
	    "\n\n" +
	    "\tb. \"Collection\" means a collection of literary or artistic " +
	    "works, such as encyclopedias and anthologies, or performances, " +
	    "phonograms or broadcasts, or other works or subject matter " +
	    "other than works listed in Section 1(f) below, which, by reason " +
	    "of the selection and arrangement of their contents, constitute " +
	    "intellectual creations, in which the Work is included in its " +
	    "entirety in unmodified form along with one or more other " +
	    "contributions, each constituting separate and independent works " +
	    "in themselves, which together are assembled into a collective " +
	    "whole. A work that constitutes a Collection will not be " +
	    "considered an Adaptation (as defined above) for the purposes of " +
	    "this License." +
	    "\n\n" +
	    "\tc. \"Distribute\" means to make available to the public the " +
	    "original and copies of the Work or Adaptation, as appropriate, " +
	    "through sale or other transfer of ownership." +
	    "\n\n" +
	    "\td. \"Licensor\" means the individual, individuals, entity or " +
	    "entities that offer(s) the Work under the terms of this License." +
	    "\n\n" +
	    "\te. \"Original Author\" means, in the case of a literary or " +
	    "artistic work, the individual, individuals, entity or entities " +
	    "who created the Work or if no individual or entity can be " +
	    "identified, the publisher; and in addition (i) in the case of a " +
	    "performance the actors, singers, musicians, dancers, and other " +
	    "persons who act, sing, deliver, declaim, play in, interpret or " +
	    "otherwise perform literary or artistic works or expressions of " +
	    "folklore; (ii) in the case of a phonogram the producer being " +
	    "the person or legal entity who first fixes the sounds of a " +
	    "performance or other sounds; and, (iii) in the case of " +
	    "broadcasts, the organization that transmits the broadcast." +
	    "\n\n" +
	    "\tf. \"Work\" means the literary and/or artistic work offered " +
	    "under the terms of this License including without limitation " +
	    "any production in the literary, scientific and artistic domain, " +
	    "whatever may be the mode or form of its expression including " +
	    "digital form, such as a book, pamphlet and other writing; a " +
	    "lecture, address, sermon or other work of the same nature; a " +
	    "dramatic or dramatico-musical work; a choreographic work or " +
	    "entertainment in dumb show; a musical composition with or " +
	    "without words; a cinematographic work to which are assimilated " +
	    "works expressed by a process analogous to cinematography; a " +
	    "work of drawing, painting, architecture, sculpture, engraving " +
	    "or lithography; a photographic work to which are assimilated " +
	    "works expressed by a process analogous to photography; a work " +
	    "of applied art; an illustration, map, plan, sketch or " +
	    "three-dimensional work relative to geography, topography, " +
	    "architecture or science; a performance; a broadcast; a " +
	    "phonogram; a compilation of data to the extent it is protected " +
	    "as a copyrightable work; or a work performed by a variety or " +
	    "circus performer to the extent it is not otherwise considered a " +
	    "literary or artistic work." +
	    "\n\n" +
	    "\tg. \"You\" means an individual or entity exercising rights " +
	    "under this License who has not previously violated the terms of " +
	    "this License with respect to the Work, or who has received " +
	    "express permission from the Licensor to exercise rights under " +
	    "this License despite a previous violation." +
	    "\n\n" +
	    "\th. \"Publicly Perform\" means to perform public recitations " +
	    "of the Work and to communicate to the public those public " +
	    "recitations, by any means or process, including by wire or " +
	    "wireless means or public digital performances; to make " +
	    "available to the public Works in such a way that members of the " +
	    "public may access these Works from a place and at a place " +
	    "individually chosen by them; to perform the Work to the public " +
	    "by any means or process and the communication to the public of " +
	    "the performances of the Work, including by public digital " +
	    "performance; to broadcast and rebroadcast the Work by any means " +
	    "including signs, sounds or images." +
	    "\n\n" +
	    "\ti. \"Reproduce\" means to make copies of the Work by any " +
	    "means including without limitation by sound or visual " +
	    "recordings and the right of fixation and reproducing fixations " +
	    "of the Work, including storage of a protected performance or " +
	    "phonogram in digital form or other electronic medium." +
	    "\n\n" +
	    "2. Fair Dealing Rights. Nothing in this License is intended to " +
	    "reduce, limit, or restrict any uses free from copyright or " +
	    "rights arising from limitations or exceptions that are provided " +
	    "for in connection with the copyright protection under copyright " +
	    "law or other applicable laws." +
	    "\n\n" +
	    "3. License Grant. Subject to the terms and conditions of this " +
	    "License, Licensor hereby grants You a worldwide, royalty-free, " +
	    "non-exclusive, perpetual (for the duration of the applicable " +
	    "copyright) license to exercise the rights in the Work as stated " +
	    "below:" +
	    "\n\n" +
	    "\ta. to Reproduce the Work, to incorporate the Work into one or " +
	    "more Collections, and to Reproduce the Work as incorporated in " +
	    "the Collections;" +
	    "\n\n" +
	    "\tb. to create and Reproduce Adaptations provided that any such " +
	    "Adaptation, including any translation in any medium, takes " +
	    "reasonable steps to clearly label, demarcate or otherwise " +
	    "identify that changes were made to the original Work. For " +
	    "example, a translation could be marked \"The original work was " +
	    "translated from English to Spanish,\" or a modification could " +
	    "indicate \"The original work has been modified.\";" +
	    "\n\n" +
	    "\tc. to Distribute and Publicly Perform the Work including as " +
	    "incorporated in Collections; and," +
	    "\n\n" +
	    "\td. to Distribute and Publicly Perform Adaptations." +
	    "\n\n" +
	    "\te. For the avoidance of doubt:" +
	    "\n\n" +
	    "\t\ti. Non-waivable Compulsory License Schemes. In those " +
	    "jurisdictions in which the right to collect royalties through " +
	    "any statutory or compulsory licensing scheme cannot be waived, " +
	    "the Licensor reserves the exclusive right to collect such " +
	    "royalties for any exercise by You of the rights granted under " +
	    "this License;" +
	    "\n\n" +
	    "\t\tii. Waivable Compulsory License Schemes. In those " +
	    "jurisdictions in which the right to collect royalties through " +
	    "any statutory or compulsory licensing scheme can be waived, the " +
	    "Licensor waives the exclusive right to collect such royalties " +
	    "for any exercise by You of the rights granted under this " +
	    "License; and," +
	    "\n\n" +
	    "\t\tiii. Voluntary License Schemes. The Licensor waives the " +
	    "right to collect royalties, whether individually or, in the " +
	    "event that the Licensor is a member of a collecting society " +
	    "that administers voluntary licensing schemes, via that society, " +
	    "from any exercise by You of the rights granted under this " +
	    "License." +
	    "\n\n" +
	    "The above rights may be exercised in all media and formats " +
	    "whether now known or hereafter devised. The above rights " +
	    "include the right to make such modifications as are technically " +
	    "necessary to exercise the rights in other media and formats. " +
	    "Subject to Section 8(f), all rights not expressly granted by " +
	    "Licensor are hereby reserved." +
	    "\n\n" +
	    "4. Restrictions. The license granted in Section 3 above is " +
	    "expressly made subject to and limited by the following " +
	    "restrictions:" +
	    "\n\n" +
	    "\ta. You may Distribute or Publicly Perform the Work only under " +
	    "the terms of this License. You must include a copy of, or the " +
	    "Uniform Resource Identifier (URI) for, this License with every " +
	    "copy of the Work You Distribute or Publicly Perform. You may " +
	    "not offer or impose any terms on the Work that restrict the " +
	    "terms of this License or the ability of the recipient of the " +
	    "Work to exercise the rights granted to that recipient under the " +
	    "terms of the License. You may not sublicense the Work. You must " +
	    "keep intact all notices that refer to this License and to the " +
	    "disclaimer of warranties with every copy of the Work You " +
	    "Distribute or Publicly Perform. When You Distribute or Publicly " +
	    "Perform the Work, You may not impose any effective " +
	    "technological measures on the Work that restrict the ability of " +
	    "a recipient of the Work from You to exercise the rights granted " +
	    "to that recipient under the terms of the License. This Section " +
	    "4(a) applies to the Work as incorporated in a Collection, but " +
	    "this does not require the Collection apart from the Work itself " +
	    "to be made subject to the terms of this License. If You create " +
	    "a Collection, upon notice from any Licensor You must, to the " +
	    "extent practicable, remove from the Collection any credit as " +
	    "required by Section 4(b), as requested. If You create an " +
	    "Adaptation, upon notice from any Licensor You must, to the " +
	    "extent practicable, remove from the Adaptation any credit as " +
	    "required by Section 4(b), as requested." +
	    "\n\n" +
	    "\tb. If You Distribute, or Publicly Perform the Work or any " +
	    "Adaptations or Collections, You must, unless a request has been " +
	    "made pursuant to Section 4(a), keep intact all copyright " +
	    "notices for the Work and provide, reasonable to the medium or " +
	    "means You are utilizing: (i) the name of the Original Author " +
	    "(or pseudonym, if applicable) if supplied, and/or if the " +
	    "Original Author and/or Licensor designate another party or " +
	    "parties (e.g., a sponsor institute, publishing entity, journal) " +
	    "for attribution (\"Attribution Parties\") in Licensor's " +
	    "copyright notice, terms of service or by other reasonable " +
	    "means, the name of such party or parties; (ii) the title of the " +
	    "Work if supplied; (iii) to the extent reasonably practicable, " +
	    "the URI, if any, that Licensor specifies to be associated with " +
	    "the Work, unless such URI does not refer to the copyright " +
	    "notice or licensing information for the Work; and (iv) , " +
	    "consistent with Section 3(b), in the case of an Adaptation, a " +
	    "credit identifying the use of the Work in the Adaptation (e.g., " +
	    "\"French translation of the Work by Original Author,\" or " +
	    "\"Screenplay based on original Work by Original Author\"). The " +
	    "credit required by this Section 4 (b) may be implemented in any " +
	    "reasonable manner; provided, however, that in the case of a " +
	    "Adaptation or Collection, at a minimum such credit will appear, " +
	    "if a credit for all contributing authors of the Adaptation or " +
	    "Collection appears, then as part of these credits and in a " +
	    "manner at least as prominent as the credits for the other " +
	    "contributing authors. For the avoidance of doubt, You may only " +
	    "use the credit required by this Section for the purpose of " +
	    "attribution in the manner set out above and, by exercising Your " +
	    "rights under this License, You may not implicitly or explicitly " +
	    "assert or imply any connection with, sponsorship or endorsement " +
	    "by the Original Author, Licensor and/or Attribution Parties, as " +
	    "appropriate, of You or Your use of the Work, without the " +
	    "separate, express prior written permission of the Original " +
	    "Author, Licensor and/or Attribution Parties." +
	    "\n\n" +
	    "\tc. Except as otherwise agreed in writing by the Licensor or " +
	    "as may be otherwise permitted by applicable law, if You " +
	    "Reproduce, Distribute or Publicly Perform the Work either by " +
	    "itself or as part of any Adaptations or Collections, You must " +
	    "not distort, mutilate, modify or take other derogatory action " +
	    "in relation to the Work which would be prejudicial to the " +
	    "Original Author's honor or reputation. Licensor agrees that in " +
	    "those jurisdictions (e.g. Japan), in which any exercise of the " +
	    "right granted in Section 3(b) of this License (the right to " +
	    "make Adaptations) would be deemed to be a distortion, " +
	    "mutilation, modification or other derogatory action prejudicial " +
	    "to the Original Author's honor and reputation, the Licensor " +
	    "will waive or not assert, as appropriate, this Section, to the " +
	    "fullest extent permitted by the applicable national law, to " +
	    "enable You to reasonably exercise Your right under Section 3(b) " +
	    "of this License (right to make Adaptations) but not otherwise." +
	    "\n\n" +
	    "5. Representations, Warranties and Disclaimer" +
	    "\n\n" +
	    "UNLESS OTHERWISE MUTUALLY AGREED TO BY THE PARTIES IN WRITING, " +
	    "LICENSOR OFFERS THE WORK AS-IS AND MAKES NO REPRESENTATIONS OR " +
	    "WARRANTIES OF ANY KIND CONCERNING THE WORK, EXPRESS, IMPLIED, " +
	    "STATUTORY OR OTHERWISE, INCLUDING, WITHOUT LIMITATION, " +
	    "WARRANTIES OF TITLE, MERCHANTIBILITY, FITNESS FOR A PARTICULAR " +
	    "PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER " +
	    "DEFECTS, ACCURACY, OR THE PRESENCE OF ABSENCE OF ERRORS, " +
	    "WHETHER OR NOT DISCOVERABLE. SOME JURISDICTIONS DO NOT ALLOW " +
	    "THE EXCLUSION OF IMPLIED WARRANTIES, SO SUCH EXCLUSION MAY NOT " +
	    "APPLY TO YOU." +
	    "\n\n" +
	    "6. Limitation on Liability. EXCEPT TO THE EXTENT REQUIRED BY " +
	    "APPLICABLE LAW, IN NO EVENT WILL LICENSOR BE LIABLE TO YOU ON " +
	    "ANY LEGAL THEORY FOR ANY SPECIAL, INCIDENTAL, CONSEQUENTIAL, " +
	    "PUNITIVE OR EXEMPLARY DAMAGES ARISING OUT OF THIS LICENSE OR " +
	    "THE USE OF THE WORK, EVEN IF LICENSOR HAS BEEN ADVISED OF THE " +
	    "POSSIBILITY OF SUCH DAMAGES." +
	    "\n\n" +
	    "7. Termination" +
	    "\n\n" +
	    "\ta. This License and the rights granted hereunder will " +
	    "terminate automatically upon any breach by You of the terms of " +
	    "this License. Individuals or entities who have received " +
	    "Adaptations or Collections from You under this License, " +
	    "however, will not have their licenses terminated provided such " +
	    "individuals or entities remain in full compliance with those " +
	    "licenses. Sections 1, 2, 5, 6, 7, and 8 will survive any " +
	    "termination of this License." +
	    "\n\n" +
	    "\tb. Subject to the above terms and conditions, the license " +
	    "granted here is perpetual (for the duration of the applicable " +
	    "copyright in the Work). Notwithstanding the above, Licensor " +
	    "reserves the right to release the Work under different license " +
	    "terms or to stop distributing the Work at any time; provided, " +
	    "however that any such election will not serve to withdraw this " +
	    "License (or any other license that has been, or is required to " +
	    "be, granted under the terms of this License), and this License " +
	    "will continue in full force and effect unless terminated as " +
	    "stated above." +
	    "\n\n" +
	    "8. Miscellaneous" +
	    "\n\n" +
	    "\ta. Each time You Distribute or Publicly Perform the Work or a " +
	    "Collection, the Licensor offers to the recipient a license to " +
	    "the Work on the same terms and conditions as the license " +
	    "granted to You under this License." +
	    "\n\n" +
	    "\tb. Each time You Distribute or Publicly Perform an " +
	    "Adaptation, Licensor offers to the recipient a license to the " +
	    "original Work on the same terms and conditions as the license " +
	    "granted to You under this License." +
	    "\n\n" +
	    "\tc. If any provision of this License is invalid or " +
	    "unenforceable under applicable law, it shall not affect the " +
	    "validity or enforceability of the remainder of the terms of " +
	    "this License, and without further action by the parties to this " +
	    "agreement, such provision shall be reformed to the minimum " +
	    "extent necessary to make such provision valid and enforceable." +
	    "\n\n" +
	    "\td. No term or provision of this License shall be deemed " +
	    "waived and no breach consented to unless such waiver or consent " +
	    "shall be in writing and signed by the party to be charged with " +
	    "such waiver or consent." +
	    "\n\n" +
	    "\te. This License constitutes the entire agreement between the " +
	    "parties with respect to the Work licensed here. There are no " +
	    "understandings, agreements or representations with respect to " +
	    "the Work not specified here. Licensor shall not be bound by any " +
	    "additional provisions that may appear in any communication from " +
	    "You. This License may not be modified without the mutual " +
	    "written agreement of the Licensor and You." +
	    "\n\n" +
	    "\tf. The rights granted under, and the subject matter " +
	    "referenced, in this License were drafted utilizing the " +
	    "terminology of the Berne Convention for the Protection of " +
	    "Literary and Artistic Works (as amended on September 28, 1979), " +
	    "the Rome Convention of 1961, the WIPO Copyright Treaty of 1996, " +
	    "the WIPO Performances and Phonograms Treaty of 1996 and the " +
	    "Universal Copyright Convention (as revised on July 24, 1971). " +
	    "These rights and subject matter take effect in the relevant " +
	    "jurisdiction in which the License terms are sought to be " +
	    "enforced according to the corresponding provisions of the " +
	    "implementation of those treaty provisions in the applicable " +
	    "national law. If the standard suite of rights granted under " +
	    "applicable copyright law includes additional rights not granted " +
	    "under this License, such additional rights are deemed to be " +
	    "included in the License; this License is not intended to " +
	    "restrict the license of any rights under applicable law.";

	private void initializeSoundEffectsLicenseText() {
		soundEffectsLicenseText.setText(SOUND_EFFECTS_LICENSE);
	}

	/*
			--------------------
			| MAIN MENU BUTTON |
			--------------------
	*/
	@FXML
	private Button mainMenuButton;

	/*
				\\\\\\\\\\\\\\
				\ VIEW MODEL \
				\\\\\\\\\\\\\\
	*/
	private MainMenuModel mainMenuModel;

	/*
					///////
					/ SET /
					///////
	*/
	public void setMainMenuModel(
	    MainMenuModel mainMenuModel
	) {
		this.mainMenuModel = mainMenuModel;
	}

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeMainMenuButton() {
		mainMenuButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			if (mainMenuModel == null) {
				Platform.exit();
				throw new NullPointerException(
				    "mainMenuModel == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			mainMenuModel.showView();
		});
	}


	/*
		******************
		*** INITIALIZE ***
		******************
	*/
	@FXML
	public void initialize() {
		/*
		Initialize components.
		*/
		initializeGameLicenseText();
		initializeMusicLicenseText();
		initializeSoundEffectsLicenseText();
		initializeMainMenuButton();
	}
}