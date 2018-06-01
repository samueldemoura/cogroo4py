# -*- coding: utf-8 -*-
import unittest

from cogroo_interface import Cogroo, Document


class LemmaTest(unittest.TestCase):

    def setUp(self):
        self.cogroo = Cogroo.instance()

    def test_singleton(self):
        excpt_thrown = False
        try:
            Cogroo()
        except TypeError, e:
            excpt_thrown = True
            self.assertEquals(Cogroo.MSG_CALL_INSTANCE, '%s' % e)
        self.assertTrue(excpt_thrown)

    def test_lemma(self):
        lemma = self.cogroo.lemmatize('Estas laranjas estão deliciosas.')

        self.assertTrue(isinstance(lemma, unicode))
        self.assertEquals(
            lemma,
            'este laranja estar delicioso .'
        )

    def test_morpho_analysis(self):
        doc = self.cogroo.analyze('Estas laranjas estão deliciosas.')

        self.assertIsNotNone(doc)
        self.assertTrue(isinstance(doc, Document))
        self.assertNotEqual('%s' % doc.sentences[0].tokens, '')
        self.assertNotEqual('%s' % doc.sentences, '')
        self.assertNotEqual('%s' % doc, '')

    def test_grammar_checker(self):
        doc = self.cogroo.grammar_check('Elas são bonita.')

        self.assertIsNotNone(doc)
        self.assertTrue(isinstance(doc, Document))
        self.assertNotEqual('%s' % doc.mistakes, '')


if __name__ == '__main__':
    unittest.main()
