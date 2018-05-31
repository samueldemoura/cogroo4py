# -*- coding: utf-8 -*-
import unittest

from cogroo_interface import Cogroo


class LemmaTest(unittest.TestCase):

    def setUp(self):
        self.cogroo = Cogroo.instance()

    def test(self):
        lemma = self.cogroo.lemmatize('Estas laranjas estão deliciosas.')

        self.assertTrue(isinstance(lemma, unicode))
        self.assertEquals(
            lemma,
            'este laranja estar delicioso .'
        )


class MorphologicalAnalysisTest(unittest.TestCase):

    def setUp(self):
        self.cogroo = Cogroo.instance()

    def test(self):
        doc = self.cogroo.analyze('Estas laranjas estão deliciosas.')

        print doc.sentences[0].tokens
        print doc.sentences
        print doc


class GrammarCheckerTest(unittest.TestCase):

    def setUp(self):
        self.cogroo = Cogroo.instance()

    def test(self):
        doc = self.cogroo.grammar_check('Elas são bonita.')
        print doc.mistakes


if __name__ == '__main__':
    unittest.main()